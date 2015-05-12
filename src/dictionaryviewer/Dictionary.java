package dictionaryviewer;

/**
 * Dictionary.java
 * 
 * @author xxxxx
 * @email xxxxxx
 * @since 05 May 2010
 * @version 1.0.0
 */
public class Dictionary {
    private ListNode listHead;      //Contains the reference to list head.
    private int numberOfWords;      //Contains the number of words in linked list.

    /**
     * ListNode class:
     * @since 05 May 2010
     */
    public class ListNode {
        private ListNode    next;   //Contains the reference to next node.
        private DictEntry   entry;  //Contains object of every dictionary entry.

        /**
         * Constructor.
         * @param entry
         * @param next
         */
        public ListNode(DictEntry entry, ListNode next) {
            this.entry  = entry;    //Set the new node with DictEntry object and the reference to next node. If this is tail, next is null
            this.next   = next;
        }

        /**
         * Constructor with 1 paramenter.
         * @param entry
         */
        public ListNode(DictEntry entry) {
            this.entry = entry;
            this.next  = null;
        }

        /**
         * 
         * @return
         */
        public DictEntry getEntry() {
            return entry;
        }

        /**
         * Gets the reference to next node.
         * @return
         */
        public ListNode getNext() {
            return next;
        }
    }

    /**
     * Constructor.
     */
    public Dictionary() {
        listHead = null;
    }

    /**
     * Add new item without next link item into linked list.
     * @param entry value of item
     * @return the item was added.
     */
    public ListNode add(DictEntry entry) {
    	ListNode nodeRef = listHead;
    	if (nodeRef == null) {
		listHead = new ListNode(entry, null);
                this.numberOfWords++;
		return listHead;
	}
	else {
		while (nodeRef.next != null) {//Shift node to tailing node.
			nodeRef = nodeRef.next;
		}
		nodeRef.next = new ListNode(entry, null);
                this.numberOfWords++;
		return nodeRef.next;//Return the node was added
	}
    }

    /**
     * Gets the reference to head of list.
     * @return
     */
    public ListNode getListHead() {
        return listHead;
    }
    /**
     * Gets the number of words in list.
     * @return an integer, which counts the number of words of linked list.
     */
    public int getNumberOfWords() {
        return this.numberOfWords;
    }
}
