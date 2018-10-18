package nsk.lab.PrepareAppDoc.controller;

import com.mongodb.MongoClient;
import nsk.lab.PrepareAppDoc.exceptions.NotFoundException;
import nsk.lab.PrepareAppDoc.getExample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.*;

import org.bson.Document;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@RestController
@RequestMapping("PrepareAppDoc")
public class RESTController {

    @Autowired
    private MongoClient mongoClient;
    @Autowired
    private MongoTemplate template;

    @Value("${app.prepare.mongodb.collection}")
    private String prepare_collection;
    @Value("${app.service.database}")
    private String out_database;
    @Value("${app.service.collection.mqp.out}")
    private String out_collection;

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private void sendMQP(Document doc) {
// Упаковываем в конверт
        Document cover= new Document();
        cover.put("datatype", "REQUEST");
        cover.put("data", doc.toJson());
        mongoClient.getDatabase(out_database).getCollection(out_collection).insertOne(cover);
    }

    @GetMapping
    public List<Document>  GetAll() {
        log.warn("Get");
        Query q= new Query();
        q.fields().exclude("_id"); // Защита, чтобы не переписать другой документ
        return template.find(q, Document.class, prepare_collection);
    }

    @GetMapping("{ID}")
    public Document getOne(@PathVariable String ID) {
        log.warn("Get: "+ ID);
        Query q= query(where("ID").is(ID));
        q.fields().exclude("_id"); // Защита, чтобы не переписать другой документ
        Document doc= template.findOne(q, Document.class, prepare_collection);
        if ((doc == null) || doc.isEmpty())
            throw new NotFoundException();
        else
            return doc;
    }

    @PostMapping // Новый документ
    public Document create(@RequestBody Document doc) {
        log.warn("Post: "+ doc.toJson());
        doc.remove("_id"); // Защита, чтобы не переписать другой документ

//doc = new getExample().getRequest();
//doc.put("statusID", 6);
//doc.put("status_alias", "APPROVAL_OK");

        doc.put("ID", UUID.randomUUID().toString());
        doc.put("createTime", ZonedDateTime.now().format(DateTimeFormatter.ISO_OFFSET_DATE_TIME));
        template.insert(doc, prepare_collection);
        if (doc.getObjectId("_id").toString().isEmpty())
            throw new NotFoundException();
        doc.remove("_id"); // Защита, чтобы не переписать другой документ
        sendMQP(doc);
        return doc;
    };

    @PutMapping("{ID}") // Заменить документ целиком
    public void update(@PathVariable String ID, @RequestBody Document doc) {
        log.warn("Put: "+ ID+ " - "+ doc.toJson());
        doc.remove("_id"); // Защита, чтобы не переписать другой документ

        doc.put("ID", ID); // Защита, чтобы не переписать другой документ
        doc.put("editTime", ZonedDateTime.now().format(DateTimeFormatter.ISO_OFFSET_DATE_TIME));
        if (template.getDb().getCollection(prepare_collection).replaceOne(new Document("ID", ID), doc).getModifiedCount() == 0)
            throw new NotFoundException();
        sendMQP(doc);
    }

    @PatchMapping("{ID}") // Изменить часть документа
    public void updatePartial(@PathVariable String ID, @RequestBody Document doc) {
        log.warn("Patch: "+ ID+ " - "+ doc.toJson());
        doc.remove("_id"); // Защита, чтобы не переписать другой документ

        doc.put("ID", ID); // Защита, чтобы не переписать другой документ
        doc.put("editTime", ZonedDateTime.now().format(DateTimeFormatter.ISO_OFFSET_DATE_TIME));
        if (template.getDb().getCollection(prepare_collection).updateOne(new Document("ID", ID), new Document("$set", doc)).getModifiedCount() == 0)
            throw new NotFoundException();
        sendMQP(doc);
    }

    @DeleteMapping("{ID}")
    public void delete(@PathVariable String ID) {
        log.warn("Delete: "+ ID);
        if (template.remove(query(where("ID").is(ID)), prepare_collection).getDeletedCount() == 0)
            throw new NotFoundException();
    }

    @PutMapping("/search") // Поиск документов по условию
    public List<Document> search(@RequestBody Document doc) {
        log.warn("Put: "+ doc.toJson());
        Query q= new BasicQuery(doc);
        q.fields().exclude("_id"); // Защита, чтобы не переписать другой документ
        return template.find(q, Document.class, prepare_collection);
    }

}
