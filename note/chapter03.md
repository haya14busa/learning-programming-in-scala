Chapter 03 Next Steps in Scala
==============================

3.1 Step 7
----------
Scalaでは`new`をつかってオブジェクトを生成し、その時に値と型をパラメータ化できる

### パラメータ化
生成するインスタンスに「構成を設定する」こと

```
val big = new java.math.BigInteger("12345")
```

`val` は変数が参照するオブジェクトに関しては変わる可能性がある

```
for(i <- 0 to 2) {
  print(greetString(i))
}
```

- `to`は`Int`パラメータをとるメソッド!!!
- `0 to 2` は `0.to(2)`というメソッド呼び出しの省略形
- `0 to 2`は配列ではなくシーケンスの一種を返している。 c.f. 17

### 括弧で囲んだ値を適用したコードははapplyメソッドを呼び出してる
- 配列もそう
- `greetString(i)` は `greetString.apply(i)`に変換される
- `greetString(0) = "Hello"` は `greetString.update(0, "Hello")` に変換される

### 配列の生成&初期化
```
val numNames = Array("zero", "one", "two")
numNames.foreach(println)
```

- 新しい配列を作って返す `apply` というファクトリーメソッドの呼び出し
- `apply` メソッドは **Array companion object** で定義されている
- 可変長引数をとる。連続パラメータ(repeated parameters)とも呼ぶ。 c.f. 8.8

3.2 Step 8 Use lists
--------------------

- Array 配列はミュータブル
- List はImmutable

```
val oneTwo = List(1, 2)
val threeFour = List(3, 4)
val oneTwoThreeFour = oneTwo ::: threeFour
println(oneTwo + " and " + threeFour + " were not mutated.")
println("Thus, " + oneTwoThreeFour + " is a new list.")
```

### Note
`List.apply()`はscala.List companion object の factory method として定義されているので, `new List`と書く必要はない。companion objectについては c.f. 4.3

`:::`はリストの連結

#### /scala-2.10.3/src/library/scala/collection/immutable/List.scala

```
/** Adds the elements of a given list in front of this list.
  *  @param prefix  The list elements to prepend.
  *  @return a list resulting from the concatenation of the given
  *    list `prefix` and this list.
  *
  *  @usecase def :::(prefix: List[A]): List[A]
  *    @inheritdoc
  *
  *    Example:
  *    {{{List(1, 2) ::: List(3, 4) = List(3, 4).:::(List(1, 2)) = List(1, 2, 3, 4)}}}
  */
def :::[B >: A](prefix: List[B]): List[B] =
  if (isEmpty) prefix
  else if (prefix.isEmpty) this
  else (new ListBuffer[B] ++= prefix).prependToList(this)
```

### cons ::
```
val twoThree = List(2, 3)
val oneTwoThree = 1 :: twoThree
println(oneTwoThree)
```

- cons: construct
- 既存のリストの先頭に新しい要素を追加して得られるリストを返す

### Caveat
メソッドの末尾がコロン`:`の場合は右被演算子になる c.f. 5.8

`1 :: twoThree` -> twoThree.::(1)

### Nil
空のリスト

```
val oneTwoThree = 1 :: 2 :: 3 :: Nil
```

`Nil`がないと`::`がIntオブジェクトのメソッドとして定義されるため、`Nil`は必須

### List 操作

```
scala> List()
res0: List[Nothing] = List()

scala> Nil
res1: scala.collection.immutable.Nil.type = List()

scala> List("Cool", "tools", "rule")
res2: List[String] = List(Cool, tools, rule)

scala> val thrill = "Will" :: "fill" :: "untill" :: Nil
thrill: List[String] = List(Will, fill, untill)

scala> List("a", "b") ::: List("c", "d")
res3: List[String] = List(a, b, c, d)

scala> thrill(2)
res4: String = untill

scala> thrill.count(s => s.length == 4)
res5: Int = 2

scala> thrill.drop(2)
res6: List[String] = List(untill)

scala> thrill.dropRight(2)
res7: List[String] = List(Will)

scala> thrill.exists(s => s == "untill")
res8: Boolean = true

scala> thrill.filter(s => s.length == 4)
res9: List[String] = List(Will, fill)

scala> thrill.forall(s => s.endsWith("l"))
res10: Boolean = true


scala> thrill.foreach(s => print(s))
Willfilluntill
scala> thrill.foreach(print)
Willfilluntill
scala> thrill.head
res13: String = Will

scala> thrill.init
res14: List[String] = List(Will, fill)

scala> thrill.isEmpty
res15: Boolean = false

scala> thrill.last
res16: String = untill

scala> thrill.length
res17: Int = 3

scala> thrill.map(s => s + "y")
res18: List[String] = List(Willy, filly, untilly)

scala> thrill.mkString(", ")
res19: String = Will, fill, untill

scala> thrill.remove(s => s.length == 4)
<console>:9: error: value remove is not a member of List[String]
              thrill.remove(s => s.length == 4)
                     ^

scala> thrill.reverse
res21: List[String] = List(untill, fill, Will)

scala> thrill.sort((s, t) => s.charAt(0).toLower < t.charAt(0).toLower)
<console>:9: error: value sort is not a member of List[String]
              thrill.sort((s, t) => s.charAt(0).toLower < t.charAt(0).toLower)
                     ^
scala> thrill.tail
res23: List[String] = List(fill, untill)
```

### List の append の問題
c.f. 24

- `:+`とすることでリスト末尾への追加操作が行える
- しかしこの操作の実行時間はリストサイズに比例して大きくなってしまう
- 先頭に追加していって、最後に`reverse`するか、`ListBuffer`を使ったあとに`toList`するとよい。 c.f. 22.2

3.3 Step 9 Use tuples
---------------------

tupleもListと同様にimmutableだが、Listと異なり、異なる型の要素を持つことができる

```
val pair = (99, "Luftballons")
println(pair._1)
println(pair._2)
```

### Caveat for tuple: `pair(0)`ではなく`pair._1`とアクセスするのはなぜか

`pair(0)`でアクセスすると仮定すると`apply()`メソッドを使うということになり、これはリストのapplyメソッドが常に同じ型を返すのに対して、タプルでは異なる型が変える可能性があるので`apply()`メソッドは使えない。

`_N`の数値が0オリジンではなく1オリジンなのは、HaskellやMLなどの他言語で、静的に型付けされたタプルは1から始まるという伝統がすでに築かれているから。

またTupleはTuple22までしか定義していない

3.4 Step 10 Use sets and maps
-----------------------------
Scalaはmutableとimmutableでcollectionをはっきり区別している。

同様に**集合(set)**と**マップ(map)**についてもmutable版とimmutable版がある

- Scala APIはSetのための**基底トレイト base trait**を持っている
- **trait**とはJavaのインターフェイスに似たもの。c.f. 12
- Scalaはさらに2つのサブトレイトを提供
  1. mutable set
  2. immutable set

```
                          scala.collection
                            Set <<trait>>
                                  |
            +---------------------+------------------+
            |                                        |
  scala.collection.immutable               scala.collection.mutable
           Set                                      Set
        <<trait>>                                <<trait>>
            |                                        |
            |                                        |
 scala.collection.immutable                scala.collection.mutable
         HashSet                                  HashSet
```


Javaではインターフェイスを**実装 implement**するが、Scalaではトレイトを**拡張 extend** または**ミックスイン mixin**する

### `->`
- Scalaのプログラムに含まれるすべてのオブジェクトから呼び出せるメソッド
- KeyとValueをを格納する2要素のタプルを返す
  - これを実現するためにimplicit conversionが使われている c.f. 21

3.5 Step 11. Learn to recognize the functional style
----------------------------------------------------

- var -> imperative style
- val -> functional style

3.6 Step 5. Read lines from a file
----------------------------------

```
import scala.io.Source

if (args.length > 0) {
  for(line <- Source.fromFile(args(0)).getLines()) {
    println(line.length + ": " + line)
  }
}
else
  Console.err.println("Please enter filename")
```

- `getLines`メソッドは一度に一行ずつ提供する`Iterator[String]`を返す
- `Iterator`は反復処理が終わると使えなくなる -> 再利用するには`toList`を使う
