Chapter 8 Functions and Closures
================================

8.1 Methods
-----------
- 関数の定義方法としてのオブジェクトのメンバーにすること: メソッド

8.2 Local functions
-------------------
- 関数をネストできる

8.3 First-class functions
-------------------------
- 関数リテラル function literals
  - インスタンス化 -> function values
- 値として渡せる
- FunctionNトレイト

### foreach
- List, Set, Array, Mapに共通するスーパートレイト、`Traversable`で定義されてる c.f. 17
- 引数として関数をとり、すべてのコレクションに関数を適用する

### filter
- 条件をパスする要素をコレクションから集める

8.4 Short forms of function lirerals
------------------------------------
- ターゲットによる型付け target typing
- `()`の省略

8.5 Placeholder syntax
----------------------
- パラメータが関数リテラルの中で1度しか使われていない場合, 1個以上のパラメータのプレースホルダとして`_`アンダースコアを使用することができる
- 埋めなければならない空白

```
someNumbers.filter(_ > 0)
```

- `:` コロンで型も指定できる

```
val f = (_: Int) + (_: Int)
```

8.6 Partially applied functions
-------------------------------
- パラメータリスト全体のプレースホルダとしても使用できる
  - ここで部分適用された関数を使っていることになる

```
someNumbers.foreach(println _)

someNumbers.foreach(x => println(x))
```

```
scala> def sum(a: Int, b:Int, c:Int) = a + b + c
sum: (a: Int, b: Int, c: Int)Int

scala> sum(1, 2, 3)
res12: Int = 6

scala> val a = sum _
a: (Int, Int, Int) => Int = <function3>

scala> a(1, 2, 3)
res13: Int = 6
```

```
scala> val b = sum(1, _: Int, 3)
b: Int => Int = <function1>

scala> b(2)
res14: Int = 6
```

8.7 Closures
------------
```
(x: Int) => x + more
```

- 自由変数 free variables (e.g. more)
- 束縛変数 bound variables (e.g. x)

- 関数リテラルから、実行時に作られる値としての関数(オブジェクト)をクロージャ(Closure)と呼ぶ
- 自由変数の束縛(binding) を「取り込んで」、関数リテラルを「閉じる(close)」
- `(x: Int) => x + 1` : closed terms 閉じた項
- `(x: Int) => x + more` : open terms 開いた項

8.8 Special function call form
------------------------------
- 連続パラメータ
- 名前付き引数
- デフォルト引数

### 8.8.1 連続パラメータ
- 可長変引数
- パラメータの型の後ろに`*`アスタリスクをつける

```
def echo(args: String*) = {
  for (arg <- args) println(arg)
}
```

内部では`String`が`Array[String]`になっているが、実際に`Array`を渡すとエラーになる。

-> 配列引数の後ろに`: _*`を追加する

```
scala> val arr = Array("What's", "up", "doc?")
arr: Array[String] = Array(What's, up, doc?)

scala> echo(arr)
<console>:10: error: type mismatch;
 found   : Array[String]
 required: String
              echo(arr)
                   ^

scala> echo(arr: _*)
What's
up
doc?
```

### 8.8.2 名前付き引数
```
scala> def speed(distance: Float, time: Float): Float =
     | distance / time
speed: (distance: Float, time: Float)Float

scala> speed(100, 10)
res3: Float = 10.0

scala> speed(distance = 100, time = 10)
res4: Float = 10.0

scala> speed(time = 10, distance = 100)
res5: Float = 10.0
```

### 8.8.3 パラメータのデフォルト値
```
def printTime(out: java.io.PrintStream = Console.out) = {
  out.println("time = " + System.currentTimeMillis())
}

printTime()
printTime(Console.err)
```

8.9 Tail recursion
------------------
- 末尾再帰最適化が行われる
- 呼び出しのたびに新しいフレームが作られない

### 8.9.1 Trace tail recursion
```
def boom(x: Int): Int =
  if (x == 0) throw new Exception("Boom!")
  else boom(x - 1) + 1
```

- scala or scalacの引数に`-g:notailcalls`で無効にできる

### 8.9.2 末尾再帰の限界
- 互いに呼び出し合う再帰関数などでは最適化ができない

```
def isEven(x: Int): Boolean =
  if (x == 0) true else isOdd(x - 1)
def isOdd(x: Int): Boolean =
  if (x != 0) true else isEven(x - 1)
```









