package networksurveyor;

/*****************************************************************************/
/*                                                                           */
/*                    Doubly-Linked List Manipulation                        */
/*                                                                           */
/*                     January 1998, Toshimi Minoura                         */
/*                                                                           */
/*****************************************************************************/


// Filename: Doubly-LinkedList_ToshimiMinoura
// Source:   TBA


// A LLNode is a node in a doubly-linked list.
class LLNode {              // class for nodes in a doubly-linked list
  LLNode prev;              // previous LLNode in a doubly-linked list
  LLNode next;              // next LLNode in a doubly-linked list
  Question question;
  int sumAnswers;           //sum of all answers together
  int numAnswers;           //Num of answers recieved
  //public char data;       // data stored in this LLNode
  LLNode() {                // constructor for head LLNode 
    prev= this;           // of an empty doubly-linked list
    next = this;
    question = new Question();
    // data = 'H';           // not used except for printing data in list head
  }

  LLNode(Question newQuestion) {       // constructor for a LLNode with data
    prev= null;
    next = null;
    question = newQuestion;
    sumAnswers = 0;
    numAnswers = 0;
    //this.data = data;     // set argument data to instance variable data
  }

  public void append(LLNode newLLNode) {  // attach newLLNode after this LLNode
    newLLNode.prev = this;
    newLLNode.next = next;
    next.prev = newLLNode;
    next = newLLNode;
    System.out.println("LLNode with data: QN " + newLLNode.question.number +
                       " appended after LLNode with data: QN " + question.number);
  }

  public void insert(LLNode newLLNode) {  // attach newLLNode before this LLNode
    newLLNode.prev = prev;
    newLLNode.next = this;
    prev.next = newLLNode;
    prev = newLLNode;
    System.out.println("LLNode with data: QN " + newLLNode.question.number +
                       " inserted before LLNode with data: QN " + question.number);
  }

  public void remove() {              // remove this LLNode
    next.prev = prev;                 // bypass this LLNode
    prev.next = next;
    System.out.println("LLNode with data: QN " + question.number + " removed");
  }
}

class DList {
  LLNode head = new LLNode();             // head of doubly-linked list

  public LLNode find(String num) {          // find LLNode containing x
    for (LLNode  current = head.next; current != head; current = current.next) {
      if (current.question.number.compareToIgnoreCase(num) == 0) {        // is x contained in current LLNode?
        System.out.println("QN " + num + " found");
        return current;               // return LLNode containing x
      }
    }
    System.out.println("QN " + num + " not found");
    return null;
  }
  
  //Method to find AND update average answer value in a node
  public void updateAverageAnswer(String qNum, int newAnswer)
  {
      LLNode desiredNode = find(qNum);
      desiredNode.sumAnswers += newAnswer;
      desiredNode.numAnswers += 1;
  }

  public String print() {                  // print content of list
    String returnString = " ";
      if (head.next == head) {             // list is empty, only header LLNode
      returnString = returnString +"List Empty";
      return returnString;
    }
    returnString = returnString + "List Content = ";
    for (LLNode  current = head.next; current != head; current = current.next) {
        int averageAnswer = 0;
        if (current.numAnswers != 0) {
            averageAnswer = current.numAnswers/current.sumAnswers;
        }
        returnString = returnString + "QN: " + current.question.number + " || Question: " + current.question.question + " || Number of Answers: " + current.numAnswers + "Average Answer: " + averageAnswer + ", ";
    }
    return returnString;
  }

  public static void main(String[] args) {
      
  }
}
