import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

object BFS extends App{

    case class Node(letter: Char, number: Int)

    val noOfVertices = 7
    val startVertex = Node('C', 2)

  // Adjusting the adjacency list to hold Nodes
    val adj: Array[ArrayBuffer[Node]] = Array.fill(noOfVertices)(ArrayBuffer.empty[Node])

  // Populate the adjacency list with Node objects
    adj(0) ++= ArrayBuffer(Node('B', 1), Node('D', 3))
    adj(1) ++= ArrayBuffer(Node('D', 3), Node('E', 4))
    adj(2) ++= ArrayBuffer(Node('A', 0), Node('F', 5))
    adj(3) ++= ArrayBuffer(Node('F', 5), Node('G', 6))
    adj(4) += Node('G', 6)
    adj(5) = ArrayBuffer()
    adj(6) += Node('F', 5)

    val path = Array.fill(noOfVertices)(-1)
    val distance = Array.fill(noOfVertices)(-1)

    // Initialize start vertex
    distance(startVertex.number) = 0
    path(startVertex.number) = startVertex.number

    val q: mutable.Queue[Node] = mutable.Queue(startVertex)

    while (q.nonEmpty) {
    for (_ <- 1 to q.size) {
      val vertexNode = q.dequeue()
      println(s"The current node is ${vertexNode.letter}")

      adj(vertexNode.number).foreach { adjNode =>
      println(s"the adjVertex is ${adjNode.letter}")
      if (distance(adjNode.number) == -1) {
          println("the distance(adjVertex) == -1 condition is true so...")
          println(s"distance(${vertexNode.letter}) is ${distance(vertexNode.number)}")
          println(s"distance(${adjNode.letter}) is ${distance(adjNode.number) } and we the sign to it distance(${vertexNode.letter}) + 1 which is ${ distance(vertexNode.number) + 1}")
          distance(adjNode.number) = distance(vertexNode.number) + 1
          println(s"the path(${adjNode.letter}) is ${path(adjNode.number)} and the sign to vertex ${vertexNode.letter}")
          path(adjNode.number) = vertexNode.number
          q.enqueue(adjNode)
          }
        }
      }
    }

    println(s"Distance from ${startVertex.letter}:")
    for (i <- 0 until noOfVertices) {
      println(s"Distance to ${(i + 'A').toChar} is ${distance(i)} from path ${(path(i) + 'A').toChar}")
    }

}
