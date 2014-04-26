Chapter  Control Abstraction
==============================

9.1 Reducing code duplication
-----------------------------
- 高階関数 higher order function

9.2 Simplifying client code
---------------------------
- e.g. Collectioの`exists`メソッド

9.3 Currying
------------
カリー化 currying

Plain

```
def plainOldSum(x:Int, y: Int) = x + y
plainOldSum(1, 2)
```

Curryin

```
def curriedSum(x: Int)(y: Int) = x + y
curriedSum(1)(2)
```

```
scala> val onePlus = curriedSum(1)_
onePlus: Int => Int = <function1>


scala> onePlus(2)
res0: Int = 3
```

9.4 Writing new control structures
----------------------------------
```
import java.io.{File, PrintWriter}

def withPrintWriter(file: File, op: PrintWriter => Unit) = {
  val writer = new PrintWriter(file)
  try {
    op(writer)
  } finally {
    writer.close()
  }
}

withPrintWriter(
  new File("date.txt"),
  writer => writer.println(new java.util.Date)
)
```

- ローンパターン loan pattern: 制御構造を実装する関数がリソースをオープンして、関数にリソースを「貸し出す」
- 引数が1つだけのときは、`()`の代わりに`{}`を使用できる
  - そうすると、`{}`内では関数リテラルが使えて便利
- しかし、引数が複数だと`{}`を使えない -> Curryingすればよい
- デフォルトで提供されているような制御構造っぽくかける!!!

9.5 By-name parameters
----------------------
- if,whileのような、中括弧の中にコードの値を渡さない制御構造をつくる
- 例としてmyAssertをつくる
- c.f. 14 for `assert`

```
// With by-name parameter
var assertionEnabled = true
def byNameAssert(predicate: => Boolean) = {
  if (assertionEnabled && !predicate) {
    throw new AssertionError
  }
}

def boolAssert(predicate: Boolean) = {
  if (assertionEnabled && !predicate) {
    throw new AssertionError
  }
}
```

- boolAssertは呼び出し前に評価されてしまう -> 副作用
- byNameAssertは呼び出しの前には評価されない -> 正しく動作する

### Call by Name
- [Scalaの名前渡しは遅延評価ではない - ぼっち勉強会](http://kannokanno.hatenablog.com/entry/20130202/1359777436)













