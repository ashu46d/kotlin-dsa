
data class DoubleNode<T>(
    var value: T,
    var next : DoubleNode<T>? = null,
    var prev : DoubleNode<T>? = null
) {
    override fun toString(): String {
        if(next != null){
            return "${value} <-> ${next.toString()}"
        } else {
            return "$value"
        }
    }

}

fun main(){
    val node1 = Node( 1)
    val node2 = Node(2)
    val node3 = Node(3)
    node1.next = node2
    node2.next = node3
    node3.next = null
    println(node1)


    val dbNode1 = DoubleNode(1)
    val dbNode2 = DoubleNode(2)
    val dbNode3 = DoubleNode(3)
    val dbNode4 = DoubleNode(4)
    dbNode1.next = dbNode2
    dbNode2.prev = dbNode1
    dbNode2.next = dbNode3
    dbNode3.prev = dbNode2
    dbNode3.next = dbNode4
    dbNode4.prev = dbNode3

    println(dbNode1)

}