package Ex1;

public class Test {
    public static void main(String[] args) {
        Individual A = new Individual("A", "01/01/1973", "Male", true);
        Individual B = new Individual("B", "01/01/1975", "Female", true);
        Individual C = new Individual("C", "01/01/1995", "Male", false);
        Individual D = new Individual("D", "01/01/1993", "Male", true);
        Individual E = new Individual("E", "01/01/2015", "Female", true);

        A.addChild(C);
        A.addChild(D);

        D.addChild(E);

        Family AFamily = new Family();
        AFamily.addMember(A);
        AFamily.addMember(B);

        Family DFamily = new Family();
        DFamily.addMember(D);

        System.out.println("Unmarried individuals:");
        findUnmarriedIndividuals(DFamily);

        System.out.println("\n");

        System.out.println("Couples with two children:");
        findCouplesWithTwoChildren(DFamily);

        System.out.println("\n");

        System.out.println("Latest generation:");
        findLatestGeneration(DFamily);
    }

    public static void findUnmarriedIndividuals(Family family) {
        for (Person member : family.getMembers()) {
            if (member instanceof Individual) {
                Individual individual = (Individual) member;
                if (!individual.isMarried()) {
                    individual.displayInfo();
                }
            }
        }
    }

    public static void findCouplesWithTwoChildren(Family family) {
        if (family.getMembers().size() == 2) {
            Person member1 = family.getMembers().get(0);
            Person member2 = family.getMembers().get(1);
            if (member1 instanceof Individual && member2 instanceof Individual) {
                Individual individual1 = (Individual) member1;
                Individual individual2 = (Individual) member2;
                if (individual1.getChildren().size() == 2 && individual2.getChildren().size() == 2) {
                    family.displayInfo();
                }
            }
        }
    }

    public static void findLatestGeneration(Family family) {
        for (Person member : family.getMembers()) {
            if (member instanceof Individual) {
                Individual individual = (Individual) member;
                if (individual.getChildren().isEmpty()) {
                    individual.displayInfo();
                }
            }
        }
    }
}