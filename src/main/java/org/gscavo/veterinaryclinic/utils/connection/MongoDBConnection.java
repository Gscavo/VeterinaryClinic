package org.gscavo.veterinaryclinic.utils.connection;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.mongodb.lang.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import static com.mongodb.MongoClientSettings.getDefaultCodecRegistry;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

@Data
@Builder
public class MongoDBConnection {

    final static private String DB_NAME = "veterinaryClinic";
    final static private String DB_PASSWORD = "4xkKhQb5IO8Pn4zX";
    final static private String BASE_URI = "mongodb+srv://admin:%s@main.6acws.mongodb.net/?retryWrites=true&w=majority&appName=main";

    final private static CodecProvider POJO_CODEC_PROVIDER = PojoCodecProvider.builder().automatic(true).build();
    final private static CodecRegistry POJO_CODEC_REGISTRY = fromRegistries(getDefaultCodecRegistry(), fromProviders(POJO_CODEC_PROVIDER));

    @NonNull
    private static MongoClient mongoClient;

    @NonNull
    public static MongoDatabase mongoDatabase;

    public static void startConnection(@Nullable Boolean isTest) {
        String uri = String.format(BASE_URI, DB_PASSWORD);
        String databaseName = Boolean.TRUE.equals(isTest) ? DB_NAME + "_test" : DB_NAME;

        try {
            mongoClient = MongoClients.create(uri);
            mongoDatabase = mongoClient.getDatabase(databaseName).withCodecRegistry(POJO_CODEC_REGISTRY);
        } catch (Exception e) {
            throw new ExceptionInInitializerError(e.getMessage());
        }
    }
}
