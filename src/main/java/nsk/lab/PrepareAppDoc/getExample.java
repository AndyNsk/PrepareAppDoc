package nsk.lab.PrepareAppDoc;

import com.mongodb.DBObject;
import com.mongodb.util.JSON;
import org.bson.Document;

public class getExample {

    public static String request=
        "{" +
        "    \"ID\": \"550e8400-e29b-41d4-a716-446655440000\"," +
        "    \"statusID\": 3," +
        "    \"status_alias\": \"CREATED\"," +
        "    \"header\": {" +
        "    }" +
        "    \"request\": {" +
        "        \"createTime\": \"2018-09-06T09:08:12+07:00\"," +
        "        \"creatorID\": 1," +
        "        \"editTime\": \"2018-09-06T09:08:12+07:00\"," +
        "        \"editorID\": 1," +
        "        \"files\": [\"Фото образца лампы.png\"]" +
        "    }" +
        "    \"views\": [" +
        "        {" +
        "            \"viewID\": \"1\"," +
        "            \"viewType\": \"HEADER\"," +
        "        }," +
        "        {" +
        "            \"viewID\": 2," +
        "            \"viewType\": \"FOOTER\"," +
        "        }," +
        "        {" +
        "            \"viewID\": 3," +
        "            \"viewType\": \"DATA\"," +
        "            \"actionID\": 12," +
        "            \"resourceID\": 112," +
        "            \"subjects\": [{" +
        "            \"typeID\": 45," +
        "            \"subTypeID\": 45," +
        "            \"inventoryNumber\": \"1234567\"," +
        "            \"networkName\": \"d50-III-dsp\"," +
        "            \"userID\": 543," +
        "            }]," +
        "            \"address\": {\"addressID\": 3, \"room\": \"103\", \"description\": \"\"}," +
        "            \"reason\": \"Приказ ВН № 45-5-6-7/14398\"" +
        "            \"description\": \"В связи с переездом в другое здание\"" +
        "        }," +
        "        {" +
        "            \"viewID\": 4," +
        "            \"viewType\": \"DATA\"," +
        "            \"actionID\": 12," +
        "            \"resourceID\": 101," +
        "            \"subjects\": [{" +
        "            \"typeID\": 45," +
        "            \"subTypeID\": 3," +
        "            \"inventoryNumber\": \"355225\"," +
        "            \"numberVTS\": \"2345\"," +
        "            \"userID\": 543," +
        "            }, {" +
        "            \"typeID\": 45," +
        "            \"subTypeID\": 4," +
        "            \"inventoryNumber\": \"355226\"," +
        "            \"numberVTS\": \"3345\"," +
        "            \"userID\": 543," +
        "            }]," +
        "            \"address\": {\"addressID\": 3, \"room\": \"103\", \"description\": \"\"}," +
        "            \"reason\": \"Приказ ВН № 45-5-6-7/14398\"" +
        "            \"description\": \"В связи с переездом в другое здание\"" +
        "        }," +
        "        {" +
        "            \"viewID\": 5," +
        "            \"viewType\": \"DATA\"," +
        "            \"actionID\": 13," +
        "            \"resourceID\": 112," +
        "            \"subjects\": [{" +
        "            \"typeID\": 45," +
        "            \"subTypeID\": 45," +
        "            \"inventoryNumber\": \"1234567\"," +
        "            \"networkName\": \"d50-III-dsp\"," +
        "            \"userID\": 543," +
        "            }]" +
        "            \"address\": {\"addressID\": 5, \"room\": \"218\", \"description\": \"\"}," +
        "            \"reason\": \"Приказ ВН № 45-5-6-7/14398\"" +
        "            \"description\": \"В связи с переездом в другое здание\"" +
        "        }," +
        "        {" +
        "            \"viewID\": 6," +
        "            \"viewType\": \"DATA\"," +
        "            \"actionID\": 13," +
        "            \"resourceID\": 101," +
        "            \"subjects\": [{" +
        "            \"typeID\": 45," +
        "            \"subTypeID\": 3," +
        "            \"inventoryNumber\": \"355225\"," +
        "            \"numberVTS\": \"2345\"," +
        "            \"userID\": 543," +
        "            }, {" +
        "            \"typeID\": 45," +
        "            \"subTypeID\": 4," +
        "            \"inventoryNumber\": \"355226\"," +
        "            \"numberVTS\": \"3345\"," +
        "            \"userID\": 543," +
        "            }]" +
        "            \"address\": {\"addressID\": 5, \"room\": \"218\", \"description\": \"\"}," +
        "            \"reason\": \"Приказ ВН № 45-5-6-7/14398\"" +
        "            \"description\": \"В связи с переездом в другое здание\"" +
        "        }," +
        "        {" +
        "            \"viewID\": 7," +
        "            \"viewType\": \"DATA\"," +
        "            \"actionID\": 14," +
        "            \"subjects\": [{" +
        "            \"typeID\": 451," +
        "            \"subTypeID\": 3," +
        "            \"inventoryNumber\": \"3553875\"" +
        "            }, {" +
        "            \"typeID\": 451," +
        "            \"subTypeID\": 5," +
        "            \"inventoryNumber\": \"3551122\"" +
        "            }]," +
        "            \"path\": {\"from\": {\"addressID\": 5, \"room\": \"218\", \"description\": \"\"}, \"to\": {\"addressID\": 5, \"room\": \"218\", \"description\": \"\"}}," +
        "            \"reason\": \"Приказ ВН № 45-5-6-7/14398\"" +
        "            \"description\": \"В связи с переездом в другое здание\"" +
        "        }" +
        "    ]" +
        "    \"tasks\": [" +
        "        {" +
        "            \"taskID\": 1," +
        "            \"viewID\": 3," +
        "            \"actionID\": 12," +
        "            \"resourceID\": 112," +
        "            \"subjects\": [{" +
        "            \"typeID\": 45," +
        "            \"subTypeID\": 45," +
        "            \"inventoryNumber\": \"1234567\"," +
        "            \"networkName\": \"d50-III-dsp\"," +
        "            \"userID\": 543," +
        "            }]" +
        "            \"address\": {\"addressID\": 3, \"room\": \"103\", \"description\": \"\"}," +
        "        }," +
        "        {" +
        "            \"taskID\": 2," +
        "            \"viewID\": 4," +
        "            \"actionID\": 12," +
        "            \"resourceID\": 101," +
        "            \"subjects\": [{" +
        "            \"typeID\": 45," +
        "            \"subTypeID\": 3," +
        "            \"inventoryNumber\": \"355225\"," +
        "            \"numberVTS\": \"2345\"," +
        "            \"userID\": 543," +
        "            }]" +
        "            \"address\": {\"addressID\": 3, \"room\": \"103\", \"description\": \"\"}," +
        "        }," +
        "        {" +
        "            \"taskID\": 3," +
        "            \"viewID\": 4," +
        "            \"actionID\": 12," +
        "            \"resourceID\": 101," +
        "            \"subjects\": [{" +
        "            \"typeID\": 45," +
        "            \"subTypeID\": 4," +
        "            \"inventoryNumber\": \"355226\"," +
        "            \"numberVTS\": \"3345\"," +
        "            \"userID\": 543," +
        "            }]" +
        "            \"address\": {\"addressID\": 3, \"room\": \"103\", \"description\": \"\"}," +
        "        }," +
        "        {" +
        "            \"taskID\": 4," +
        "            \"viewID\": 5," +
        "            \"actionID\": 13," +
        "            \"resourceID\": 112," +
        "            \"subjects\": [{" +
        "            \"typeID\": 45," +
        "            \"subTypeID\": 45," +
        "            \"inventoryNumber\": \"1234567\"," +
        "            \"networkName\": \"d50-III-dsp\"," +
        "            \"userID\": 543," +
        "            }]" +
        "            \"address\": {\"addressID\": 5, \"room\": \"218\", \"description\": \"\"}," +
        "        }," +
        "        {" +
        "            \"taskID\": 5," +
        "            \"viewID\": 6," +
        "            \"actionID\": 13," +
        "            \"resourceID\": 101," +
        "            \"subjects\": [{" +
        "            \"typeID\": 45," +
        "            \"subTypeID\": 3," +
        "            \"inventoryNumber\": \"355225\"," +
        "            \"numberVTS\": \"2345\"," +
        "            \"userID\": 543," +
        "            }]" +
        "            \"address\": {\"addressID\": 5, \"room\": \"218\", \"description\": \"\"}," +
        "        }," +
        "        {" +
        "            \"taskID\": 6," +
        "            \"viewID\": 6," +
        "            \"actionID\": 13," +
        "            \"resourceID\": 101," +
        "            \"subjects\": [{" +
        "            \"typeID\": 45," +
        "            \"typeID\": 4," +
        "            \"inventoryNumber\": \"355226\"," +
        "            \"numberVTS\": \"3345\"," +
        "            \"userID\": 543," +
        "            }]" +
        "            \"address\": {\"addressID\": 3, \"room\": \"103\", \"description\": \"\"}," +
        "        }," +
        "        {" +
        "            \"taskID\": 7," +
        "            \"viewID\": 7," +
        "            \"actionID\": 14," +
        "            \"subjects\": [{" +
        "            \"typeID\": 451," +
        "            \"subTypeID\": 3," +
        "            \"inventoryNumber\": \"3553875\"" +
        "            }]," +
        "            \"path\": {\"from\": {\"addressID\": 5, \"room\": \"218\", \"description\": \"\"}, \"to\": {\"addressID\": 5, \"room\": \"218\", \"description\": \"\"}}," +
        "        }," +
        "        {" +
        "            \"taskID\": 8," +
        "            \"viewID\": 7," +
        "            \"actionID\": 14," +
        "            \"subjects\": [{" +
        "            \"typeID\": 451," +
        "            \"subTypeID\": 5," +
        "            \"inventoryNumber\": \"3551122\"" +
        "            }]," +
        "            \"path\": {\"from\": {\"addressID\": 5, \"room\": \"218\", \"description\": \"\"}, \"to\": {\"addressID\": 5, \"room\": \"218\", \"description\": \"\"}}" +
        "        }" +
        "    ]" +
        "}";

    public Document getRequest() {
        return Document.parse(request);
    }
}
