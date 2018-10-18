package nsk.lab.PrepareAppDoc.Scheduled;

import nsk.lab.PrepareAppDoc.exceptions.NotFoundException;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.UpdateOptions;
import com.mongodb.client.result.UpdateResult;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class TimerQueue {

    @Autowired
    private MongoClient mongoClient;
    @Autowired
    private MongoTemplate template;

    @Value("${app.prepare.mongodb.collection}")
    private String prepare_collection;
    @Value("${app.service.database}")
    private String out_database;
    @Value("${app.service.collection.mqp.in}")
    private String in_collection;

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Scheduled(fixedRateString = "${app.mqp.timer.Interval}")
    public void reportCurrentTime() {
        MongoCollection<Document> collection_in= mongoClient.getDatabase(out_database).getCollection(in_collection);
        for (Document cover : collection_in.find()) {
// Распаковываем конверт
            if(!cover.getString("datatype").equals("REQUEST"))
                log.warn("MQP. Неверный параметр datatype= "+ cover.getString("datatype"));
            Document doc= Document.parse(cover.getString("data"));

            ObjectId _id= doc.getObjectId("_id");
            doc.remove("_id");
            Bson filter= new Document("ID", doc.getString("ID"));
//            UpdateResult updateResult= template.getDb().getCollection(prepare_collection).replaceOne(filter, doc, new UpdateOptions().upsert(true));
            UpdateResult updateResult= template.getDb().getCollection(prepare_collection).updateOne(filter, new Document("$set", doc));
            if (updateResult.getModifiedCount() == 1)
                log.warn("MQP. Произведена замена документа: "+ filter);
            else
                log.warn("MQP. Добавлен документ: "+ filter);
            collection_in.deleteOne(new Document("_id", _id));


        }
    }
}
