public class Main {
    public static void main(String[] args) {
        CustomArrayList test = new CustomArrayList(11);
        test.add(1);
        test.add(2);
        test.add(3);
        test.add(4);
        test.add(5);
        test.add(6);
        test.add(7);
        test.add(8);
        test.add(9);
        test.add(10);
        test.add(11);
        System.out.println("get at 5: " + test.get(5));
        System.out.println("contains 1: " + test.contains(1));
        System.out.println("size: " + test.size());
        System.out.println("is empty: " + test.isEmpty());
        System.out.println("print all: " + test.print());
        test.delete(2);
        System.out.println("delete 2: " + test.print());
        test.insert(1,5);
        System.out.println("insert 5@1: " + test.print());

    }
}