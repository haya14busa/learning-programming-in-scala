Chapter 15 Case Classes and Pattern Matching
============================================


15.1 A simple example
---------------------
- DSL: ドメイン固有言語

### 15.1.1 ケースクラス
- case classes
- classの構文に適切な変更を加えるようになる

1. クラスと同じ名前のファクトリーメソッドを追加する
  - これによって`new Var("x")` の代わりに、`Var("x")`とかける
2. ケースクラスのパラメータリストないのすべてのパラメータに暗黙のうちに`val`プレフィックスをつける
  - このため、パラメータがフィールドになる
3. `toString`, `hashCode`, `equals`など、"自然"な実装を追加する
4. `copy`メソッドの追加
  - ほぼ同じクラスのインスタンスを作るときに便利

### 15.1.2 Pattern matching
- `<selector expression> match { <alternative> }`
- `case <pattern> => <body>`
- 定数パターン constant patterns : `==`で比較して定数と等しい値にマッチ
- 変数パターン variable patterns : すべての値にマッチし、ケース節右側で使える
- ワイルドカードパターン wildcard pattern : `_`すべての値にマッチ。値を参照する変数は導入されない
- コンストラクターパターン constructor patterns : `UnOp("-", e)`

### 15.1.3 matchとswitchの違い
1. 例外を除けば、`match`は結果値を返す
2. デフォルトでbreak
3. マッチしなければ`MatchError`の例外

15.2 Kinds of patterns
----------------------

### 15.2.1 ワイルドカードパターン
- `_`

```
expr match {
  case BinOp(_, _, _) => println(expr + " is a binary operation")
  case _ => println("It's something else")
}
```

### 15.2.2 定数パターン
- constant patterns
- 自分自身としかマッチしない
- 任意のリテラルを使用できる: e.g. `5`, `true`, `"hello"`

### 15.2.3 変数パターン
```
def describe(x: Any) = x match {
  case 0 => "0"
  case somethingElse => "not zero: " + somethingElse
}
```

### 15.2.3.1 変数か定数か
- 先頭が小文字 -> パターン変数
- 先頭が大文字 -> 定数
- 小文字でパターン定数を使う: \`\`で囲む
  - c.f. 6.10

### 15.2.4 コンストラクターパターン
- constructor patterns
- e.g. `BinOp("+", e, Number(0))`
- case クラスであることが前提
- **深いパターンマッチ**
  - パラメータの中までオブジェクトをチェックしている

```scala
expr match {
  case BinOp("+", e, Number(0)) => println("a deep match")
  case _ => "hoge"
}
```

### 15.2.5 シーケンスパターン
- `List`や`Array`といったシーケンス型でもパターンマッチが可能

```
expr match {
  case List(0, _, _) => println("found it")
  case _ =>
}
```

任意の長さ
```
expr match {
  case List(0, _*) => println("found it")
  case _ =>
}
```

### 15.2.6 タプルパターン
```
object TuplePatterns {
  def tupleDemo(expr: Any) = expr match {
    case (a, b, c) => println("matched " + a + b + c)
    case _ =>
  }
  def main(args: Array[String]) {
    tupleDemo(("a ", 3, "-tuple"))
  }
}
```

### 15.2.7 型付きパターン
- 型テストと型キャストの代用品として使える

```
object TypePattens {
  def generalSize(x: Any) = x match {
    case s: String => s.length
    case m: Map[_, _] => m.size
    case _ => -1
  }
  def main(args: Array[String]) {
    println(generalSize("abc"))
    println(generalSize(Map(1 -> 'a', 2 -> 'b')))
    println(generalSize(math.Pi))
  }
}
```

- `s: String` 型付きパターン
- 型テスト: `expr.isInstanceOf[String]`
- 型キャスト: `expr.asInstanceOf[String]`
- 型パラメータ: `[String]`

### 15.2.7.1 型消去 type erasure
- 消去モデル erasure model
- 引数の型まで区別できない(`Map`その他)
- 配列のみOK

### 15.2.8 変数の束縛
- 変数束縛パターン variable-binding pattern

15.3 Pattern guards
-------------------
- `BinOp("+", Var("x"), Var("x"))`
- -> `BinOp("*", Var("x"), Number(2))`
- Scalaはパターンを線形 linearなものに制限している
  - 2度以上登場させることができない

```
scala> def simplifyAdd(e: Expr) = e match {
     |   case BinOp("+", x, x) => BinOp("*", x, Number(2))
     |   case _ => e
     | }
<console>:8: error: x is already defined as value x
         case BinOp("+", x, x) => BinOp("*", x, Number(2))
                            ^

scala> def simplifyAdd(e: Expr) = e match {
     |   case BinOp("+", x, y) if x == y =>
     |     BinOp("*", x, Number(2))
     |   case _ => e
     | }
```

- `if`でガードできる

15.4 Pattern Overlaps
---------------------
- 順番が大事
- compileすると`unreachable code`とErrorがでることも

15.5 Sealed classes
-------------------
- sealed クラス: 同じファイルで定義されているサブクラス以外は新しくサブクラスを作れないようにする

```
sealed abstract class Expr
case class Var(name: String) extends Expr
case class Number(name: Double) extends Expr
case class UnOp(operator: String, arg: Expr) extends Expr
case class BinOp(operator: String,
                left: Expr,
                right: Expr) extends Expr
```

```
object SealedExprSuite {
  def describe(e: Expr): String = e match {
    case Number(_) => "a number"
    case Var(_) => "a variable"
  }
  def main(args: Array[String]) {
  }
}
```

#### Compile Error

```
Chapter15/SealedExprSuite.scala:2: warning: match may not be exhaustive.
It would fail on the following inputs: BinOp(_, _, _), UnOp(_, _)
  def describe(e: Expr): String = e match {
                                  ^
one warning found
```

#### 無視するには?
```
def describe2(e: Expr): String = (e: @unchecked) match {
  case Number(_) => "a number"
  case Var(_) => "a variable"
}
```

アノテーション `@unchecked`をつける c.f. 27


15.6 The Option Type
--------------------
- Option
  - `Some(x)` -> `x`が実際の値
  - `None` => 値がないことを表す

```
scala> val capitals =
     |   Map("France" -> "Paris", "Japan" -> "Tokyo")
capitals: scala.collection.immutable.Map[String,String] = Map(France -> Paris, Japan -> Tokyo)

scala> capitals get "France"
res0: Option[String] = Some(Paris)

scala> capitals get "North Pole"
res1: Option[String] = None
```

### オプション型の分解にはパターンマッチをよく使う
```
scala> def show(x: Option[String]) = x match {
     |   case Some(s) => s
     |   case None => "?"
     | }
show: (x: Option[String])String

scala> show(capitals get "France")
res3: String = Paris

scala> show(capitals get "North Pole")
res4: String = ?
```

### 利点
- 時々`null`になる可能性があることがわかる

15.7 Patterns everywhere
------------------------

### 15.7.1 変数定義におけるパターン
一つの代入で複数の変数を定義

```
scala> val myTuple = (123, "abc")
myTuple: (Int, String) = (123,abc)

scala> val (number, string) = myTuple
number: Int = 123
string: String = abc
```

```
object PatternVar {
  def main(args: Array[String]) {
    val exp = BinOp("*", Number(5), Number(1))
    val BinOp(op, left, right) = exp
    println(op)
    println(left)
    println(right)
  }
}
```

### 15.7.2 部分関数としてのケースシーケンス
- case sequenceは関数リテラル
- case sequenceは部分関数 partial functions になる

```
scala> val second: List[Int] => Int = {
     |   case x :: y :: _ => y
     | }
<console>:7: warning: match may not be exhaustive.
It would fail on the following input: List(_)
       val second: List[Int] => Int = {
                                      ^
second: List[Int] => Int = <function1>

scala> second(List(5,6,7))
res0: Int = 6

scala> second(List(5,6,7,8))
res1: Int = 6

scala> second(List(5,6))
res2: Int = 6

scala> second(List(5))
scala.MatchError: List(5) (of class scala.collection.immutable.$colon$colon)
        at $anonfun$1.apply(<console>:7)
        at $anonfun$1.apply(<console>:7)
        ...
```

```
scala> val second: PartialFunction[List[Int], Int] = {
     |   case x :: y :: _ => y
     | }
second: PartialFunction[List[Int],Int] = <function1>

scala> second.isDefinedAt(List(5,6,7))
res4: Boolean = true

scala> second.isDefinedAt(List())
res5: Boolean = false
```

- 全関数 complete functions
- 基本的には全関数
- 処理されない値が渡されないことがはっきりしている場合、かつ、かならず`isDefinedAt`をチェックするようなフレームワークを使っている場合のみ、部分関数が便利な場合がある

15.7.3 for式内のパターン
------------------------
```
scala> val capitals =
     |   Map("France" -> "Paris", "Japan" -> "Tokyo")
capitals: scala.collection.immutable.Map[String,String] = Map(France -> Paris, Japan -> Tokyo)

scala> for ((country, city) <- capitals)
     |   println("The capital of " + country + " is " + city)
The capital of France is Paris
The capital of Japan is Tokyo
```

```
scala> val results = List(Some("apple"), None, Some("orange"))
results: List[Option[String]] = List(Some(apple), None, Some(orange))

scala> for (Some(fuit) <- results) println(fruit)
<console>:9: error: not found: value fruit
              for (Some(fuit) <- results) println(fruit)
                                                  ^

scala> for (Some(fruit) <- results) println(fruit)
apple
orange
```

