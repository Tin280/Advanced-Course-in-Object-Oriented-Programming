import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Temperature();
        System.out.println();
        Disease();
        System.out.println();
        Filter();
        System.out.println();
        Points();
        System.out.println();
    }

    private static void Temperature() {
        Temperature temp1 = new Temperature(40, Temperature.Scale.CELSIUS);
        Temperature temp2 = new Temperature(313.15, Temperature.Scale.KELVIN);
        Temperature temp3 = new Temperature(130, Temperature.Scale.FAHRENHEIT);

        System.out.println("Test temperature:");

        System.out.println("*  ******************  *");

        System.out.println("Temp1: " + temp1);
        System.out.println("Temp2: " + temp2);
        System.out.println("Temp3: " + temp3);

        System.out.println("Temp1 + Temp2: " + (temp1.add(temp2)));
        System.out.println("Temp3 + Temp1: " + (temp3.add(temp1)));
        System.out.println("Temp1 - Temp3: " + (temp1.minus(temp3)));
        System.out.println("Temp1 * Temp3: " + (temp1.multi(temp3)));
        System.out.println("Temp1 / Temp3: " + (temp1.divide(temp3)));

    }

    public static void Disease() {
        Diseases.Symptom diarrhea = new Diseases.Symptom("Diarrhea");
        Diseases.Symptom headache = new Diseases.Symptom("Headache");
        Diseases.Symptom cough = new Diseases.Symptom("Cough");

        ArrayList<Diseases.Symptom> poisoningSymptoms = new ArrayList<>();
        poisoningSymptoms.add(diarrhea);
        poisoningSymptoms.add(headache);

        ArrayList<Diseases.Symptom> coldSymptoms = new ArrayList<>();
        coldSymptoms.add(cough);

        Human human = new Human("Human A", coldSymptoms);

        Diseases flu = new Diseases("FoodPoisoning", poisoningSymptoms);
        Diseases cold = new Diseases("Cold", coldSymptoms);

        System.out.println("Disease:");
        System.out.println("*  ******************  *");
        System.out.println("Human A has symptoms: cough");
        System.out.println("Flu has symptoms: cough, headache, fever");
        System.out.println("Covid 19 has symptoms: cough, headache, fever");
        System.out.println("Cold has symptoms: cough");

        System.out.println("Human A may have Flu: " + human.mayHaveDisease(flu));
        System.out.println("Human A may have Cold: " + human.mayHaveDisease(cold));
        System.out.println("*  ******************  *");
    }

    private static void Filter() {
        ArrayList<StudentRows> rows = new ArrayList<>();
        rows.add(new StudentRows(
                "Student A",
                "Address school",
                "email1@email.com",
                "Program A",
                10));
        rows.add(new StudentRows(
                "Student B",
                "Address 358",
                "Student@email.com",
                "Program B",
                280));
        rows.add(new StudentRows(
                "Student C",
                "Address 3",
                "email3@email.com",
                "Program A",
                289));
        rows.add(new StudentRows(
                "Student D",
                "Address 4",
                "email4@email.com",
                "Program C",
                200));

        Studentfiltered filter = new Studentfiltered();
        List<StudentRows> encouragementStudents = rows.stream()
                .filter(filter::filter)
                .toList();
        System.out.println("Filter:");
        System.out.println("*  ******************  *");
        System.out.println("All students:");
        rows.forEach(System.out::println);
        System.out.println();
        System.out.println("Encouragement students:");
        encouragementStudents.forEach(System.out::println);

        System.out.println("*  ******************  *");
    }

    private static void Points() {
        System.out.println("Test point classes:");
        System.out.println("-------------------");

        System.out.println("Normal point class:");
        Point normalPoint = new Point(10, 11);
        Point normalPoint2 = normalPoint;
        System.out.println("Reading X: " + normalPoint.values[0]);
        System.out.println("Reading Y: " + normalPoint.values[1]);
        System.out.println("Reading X (shared): " + normalPoint2.values[0]);
        System.out.println("Reading Y (shared): " + normalPoint2.values[1]);
        System.out.println("Writing X, Y to 4 , 5");
        normalPoint.values[0] = 4;
        normalPoint.values[1] = 5;
        System.out.println("Reading X: " + normalPoint.values[0]);
        System.out.println("Reading Y: " + normalPoint.values[1]);
        System.out.println("Reading X (shared): " + normalPoint2.values[0]);
        System.out.println("Reading Y (shared): " + normalPoint2.values[1]);

        System.out.println();
        System.out.println("Record point class:");
        RecordPoint recordPoint = new RecordPoint(10, 11);
        RecordPoint recordPoint2 = recordPoint;
        System.out.println("Reading X: " + recordPoint.x());
        System.out.println("Reading Y: " + recordPoint.y());
        System.out.println("Reading X (shared): " + recordPoint2.x());
        System.out.println("Reading Y (shared): " + recordPoint2.y());
        System.out.println("Writing: can not change X, Y");

        System.out.println();
        System.out.println("Record number point class:");
        RecordPointNumber recordNumberPoint = new RecordPointNumber(10, 11);
        RecordPointNumber recordNumberPoint2 = recordNumberPoint;
        System.out.println("Reading X: " + recordNumberPoint.x().value);
        System.out.println("Reading Y: " + recordNumberPoint.y().value);
        System.out.println("Reading X (shared): " + recordNumberPoint2.x().value);
        System.out.println("Reading Y (shared): " + recordNumberPoint2.y().value);
        System.out.println("Writing X, Y to 8, 12");
        recordNumberPoint.x().value = 8;
        recordNumberPoint.y().value = 12;
        System.out.println("Reading X: " + recordNumberPoint.x().value);
        System.out.println("Reading Y: " + recordNumberPoint.y().value);
        System.out.println("Reading X (shared): " + recordNumberPoint2.x().value);
        System.out.println("Reading Y (shared): " + recordNumberPoint2.y().value);
    }
}