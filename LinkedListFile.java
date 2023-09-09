/**
This is a javadoc comment.
*/
public class Main
{
	/** Javadoc comment for a method */
	public static void main(String[] args) {
		SLinkedList awesomeList = new SLinkedList();
		
		awesomeList.push(-1);
		awesomeList.push(7);
		
		System.out.println("List length: " + awesomeList.length());
		
		awesomeList.printList();
		
		System.out.println(awesomeList.pop());
		System.out.println(awesomeList.peek());
		System.out.println(awesomeList.pop());
		System.out.println(awesomeList.peek());
		
		System.out.println("List length: " + awesomeList.length());
		
		awesomeList.printList();
	}
}
