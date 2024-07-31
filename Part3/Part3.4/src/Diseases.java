import java.util.List;
import java.util.HashSet;

public class Diseases {
    public String name;
    public List<Symptom> symtoms;

    static class Symptom {
        public String description;

        public Symptom(String description) {
            this.description = description;
        }
    }

    public Diseases(String name, List<Symptom> symptoms) {
        this.name = name;
        this.symtoms = symptoms;
    }
}

class Human {
    public String name;
    public HashSet<Diseases.Symptom> symptoms;

    public Human(String name, List<Diseases.Symptom> symptoms) {
        this.name = name;
        this.symptoms = new HashSet<>(symptoms);
    }

    public boolean mayHaveDisease(Diseases disease) {
        return symptoms.containsAll(disease.symtoms);
    }
}