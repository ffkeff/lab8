public class TestList {
    public static void main(String[] args) {
        MyList<String> myList = new MyList<>();
        myList.pushBack("1");
        myList.pushBack("2");
        myList.pushBack("3");

        MyList.MyIterator<String> iteratorFromStart = myList.getIteratorFromStart();
        while (iteratorFromStart.hasNext()) {
            System.out.println(iteratorFromStart.next());
        }

        System.out.println();

        MyList.MyIterator<String> iteratorFromEnd = myList.getIteratorFromEnd();
        while (iteratorFromEnd.hasPrevious()) {
            System.out.println(iteratorFromEnd.previous());
        }
    }
}
