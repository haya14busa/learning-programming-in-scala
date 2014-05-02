class Rational(n: Int, d: Int) extends Ordered[Rational] {
  // println("Created " + n + "/" + d)

  // Precondition for Rational
  require(d != 0)
  // Greatest Common Divisor
  private val g = gcd(n.abs, d.abs)
  val numer: Int = n / g
  val denom: Int = d / g
  // auxiliary constructors
  // Allow `new Rational(5)` -> 5/1
  def this(n: Int) = this(n, 1)
  override def toString = numer + "/" + denom

  def +(that: Rational): Rational = {
    new Rational(
      numer * that.denom + that.numer * denom,
      denom * that.denom
    )
  }
  def +(i: Int): Rational = {
    new Rational(numer + i * denom, denom)
  }

  def -(that: Rational): Rational = {
    new Rational(
      numer * that.denom - that.numer * denom,
      denom * that.denom
    )
  }
  def -(i: Int): Rational = {
    new Rational(numer - i * denom, denom)
  }

  def *(that: Rational): Rational = {
    new Rational(numer * that.numer, denom * that.denom)
  }
  def *(i: Int): Rational = {
    new Rational(numer * i, denom)
  }

  def /(that: Rational): Rational = {
    new Rational(numer * that.denom, denom * that.numer)
  }
  def /(i: Int): Rational = {
    new Rational(numer, denom * i)
  }

  private def gcd(a: Int, b: Int): Int = {
    if (b == 0) a else gcd(b, a % b)
  }

  def lessThan(that: Rational): Boolean = {
    //   numer
    this.numer * that.denom < that.numer * this.denom
  }

  def max(that: Rational): Rational = {
    if (this.lessThan(that)) that else this
  }

  // Related with the Ordered tarit
  def compare(that: Rational) = {
    (this.numer * that.denom) - (that.numer * this.denom)
  }

}

import scala.language.implicitConversions

object Rational {
  implicit def intToRational(x: Int) = new Rational(x)
}

object RationalTest {
  def main(args: Array[String]) {

    val a = new Rational(1, 2)
    println(a)

    val b = new Rational(2, 3)

    println(a.+(b))

    println(b.numer)
    println(b.denom)

    println(a lessThan b)
    println(a max b)

    val c = new Rational(5)
    println(c)

    val d = new Rational(66, 42)
    println(d)

    println(c * a)

    println("a: " + a)
    println(a * a)
    println(a * 2)
    println(2 * a)

    println("=" * 40)
    assert(c > d == true)
    assert(c > c == false)
    assert(c >= c == true)
    assert(c < d == false)
    assert(d < d == false)
    assert(d <= d == true)
    println("c: " + c)
    println("d: " + d)
    println(c compareTo d)
    assert((c compareTo d) == (5 * 7 - 11 * 1))
  }
}

