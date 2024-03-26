data class Node<T>(
    var value: T,
    var next: Node<T>? = null
) {
    override fun toString(): String {
        return if (next != null) {
            "$value -> ${next.toString()}"
        } else {
            "$value"
        }
    }
}


class LinkedList<T> {
    private var head: Node<T>? = null
    private var tail: Node<T>? = null
    private var size = 0
    private fun isEmpty() = size == 0
    override fun toString(): String {
        return if(isEmpty()){
            "Empty List"
        } else {
            head.toString()
        }
    }

    /**
    * This function pushes a node to the head of a list
    * */
    fun pushNode(node : Node<T>){
        node.next = head
        head = node
        size++
        if(tail == null){
            tail = head
        }
    }

    /**
     * This function appends a Node to the end of the list
     * */
    fun appendNode(node : Node<T>){
        if(isEmpty()){
            head = node
            tail = node
            tail?.next = null
            size++
            return
        }
        tail?.next = node
        tail = node
        size++
    }

    /**
     * This function insterts a node after a particular node**/
    //todo
    fun insertAt(newNode:Node<T>,afterNode : Node<T>){

    }

    fun nodeAt(index : Int) : Node<T>? {
        var currentNode = head
        var currentIndex = 0

        while(currentIndex < index && currentNode != null){
            currentNode = currentNode.next
            currentIndex++
        }
        return currentNode
    }

    fun pop(){
        if(!isEmpty()) size--
        if(size == 0){
            tail = null
            head = null
        }
        head = head?.next
    }

    fun removeLast() {
        val head = head ?: return
        if(head.next == null) {
            pop()
            return
        }

        var prev = head
        var curr = head
        var next = curr.next

        while(next != null){
            prev = curr
            curr = next
            next = curr.next
        }
        prev.next = null
        tail = prev
        size--
    }

    fun removeAfter(node : Node<T>){
        if(node.next == tail) {
            tail = node
        }
        if(node.next != null){
            size--
        }
        node.next = node.next?.next
    }

    fun reverseLists(){
        var prev: Node<T>? = null
        var curr: Node<T>? = head
        var nextNode: Node<T>? = null

        while(curr != null){
            nextNode = curr.next
            curr.next = prev
            prev = curr
            curr = nextNode
        }
        head = prev
    }

    fun middleElement() : Node<T>?{
        var slow = head
        var fast = head

        while(fast?.next != null){
            fast = fast.next?.next
            slow = slow?.next
        }

        return slow
    }

}

fun main() {
    val list = LinkedList<Int>()
    list.appendNode(Node(1))
    list.appendNode(Node(2))
    list.appendNode(Node(3))
    list.appendNode(Node(4))
    list.appendNode(Node(5))
    list.appendNode(Node(6))
    list.appendNode(Node(7))

    println("originalList : $list")
    list.reverseLists()
    println("reversedList : $list")

    println("middle : ${list.middleElement()}")

}