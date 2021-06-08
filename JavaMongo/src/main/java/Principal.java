import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;

import java.util.Arrays;
import java.util.Date;

public class Principal {
    public static void main(String[] args) {

        MongoClient cliente = new MongoClient();
        MongoDatabase bancoDeDados = cliente.getDatabase("test");
        MongoCollection<Document> alunos = bancoDeDados.getCollection("alunos");
        Document aluno = alunos.find().first();
        System.out.println(aluno);
        Document novoAluno = new Document("nome", "Joao")
                .append("data_nascimento", new Date(2001, 10, 10))
                .append("curso", new Document("nome", "Administração"))
                .append("notas", Arrays.asList(10, 9, 8))
                .append("habilidades", Arrays.asList(new Document()
                                .append("nome", "Inglês")
                                .append("nível", "Avançado"),
                        new Document().append("nome", "Japonês").append("nível", "Básico")));

        alunos.insertOne(novoAluno);
        alunos.updateOne(Filters.eq("nome", "Joao"),
                new Document("$set", new Document("nome", "Joao_Silva")));
        alunos.deleteOne(Filters.eq("nome", "Joao_Silva"));
        cliente.close();
    }
}