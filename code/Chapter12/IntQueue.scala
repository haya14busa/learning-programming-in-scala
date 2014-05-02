import scala.collection.mutable.ArrayBuffer

abstract class IntQueue {
  // FIFO: Firtst In, First Out
  def get(): Int
  def put(x: Int)
}

class BasicIntQueue extends IntQueue {
  private val buf = new ArrayBuffer[Int]
  def get() = buf.remove(0)
  def put(x: Int) = { buf += x }
}

trait Doubling extends IntQueue {
  abstract override def put(x: Int) = { super.put(2 * x) }
}

trait Incrementing extends IntQueue {
  abstract override def put(x: Int) = { super.put(x + 1) }
}

trait Filtering extends IntQueue {
  abstract override def put(x: Int) = {
    if (x >= 0) super.put(x)
  }
}

class MyQueue extends BasicIntQueue with Doubling

object IntQueueTest {
  def main(args: Array[String]) {
    val queue = new BasicIntQueue
    queue.put(10)
    queue.put(20)
    queue.put(15)
    println(queue.get())
    println(queue.get())
    println(queue.get())

    val myqueue = new MyQueue
    myqueue.put(10)
    myqueue.put(20)
    myqueue.put(15)
    assert(myqueue.get() == 20)
    assert(myqueue.get() == 40)
    assert(myqueue.get() == 30)

    val myqueue2 = new BasicIntQueue with Doubling
    myqueue2.put(10)
    myqueue2.put(20)
    myqueue2.put(15)
    assert(myqueue2.get() == 20)
    assert(myqueue2.get() == 40)
    assert(myqueue2.get() == 30)

    println("=" * 40)
    val myqueue3 = (new BasicIntQueue with Doubling
                                      with Incrementing
                                      with Filtering)
    myqueue3.put(-1)
    myqueue3.put(0)
    myqueue3.put(1)

    println(myqueue3.get())
    println(myqueue3.get())

    println("=" * 40)
    val myqueue4 = (new BasicIntQueue with Filtering
                                      with Doubling
                                      with Incrementing)
    myqueue4.put(-1)
    myqueue4.put(0)
    myqueue4.put(1)

    println(myqueue4.get())
    println(myqueue4.get())
    println(myqueue4.get())

  }
}
