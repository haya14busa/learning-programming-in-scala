Chapter 02 First Steps in Scala
===============================

Step 1. Learn to use the Scala interpreter
------------------------------------------
```
$ scala
Welcome to Scala version 2.10.3 (Java HotSpot(TM) 64-Bit Server VM, Java 1.8.0_05).
Type in expressions to have them evaluated.
Type :help for more information.

scala> 1 + 2
res0: Int = 3
```

`Int`はクラスの単純名、`scala.Int`は完全名


resXも使える
```
scala> res0 * 3
res1: Int = 9
```

Step 2. Define some variables
-----------------------------
1. **val** : finalに似ている。初期化後に再代入できない
2. **var** : 何度でも代入可能

### Completion
`.`のあと、`<Tab>`でメソッドを補完できる

```
scala> val msg = "Happy Vimming!"
msg: String = Happy Vimming!

scala> msg.
+                     asInstanceOf          charAt                chars
codePointAt           codePointBefore       codePointCount        codePoints
compareTo             compareToIgnoreCase   concat                contains
contentEquals         endsWith              equalsIgnoreCase      getBytes
getChars              indexOf               intern                isEmpty
isInstanceOf          lastIndexOf           length                matches
offsetByCodePoints    regionMatches         replace               replaceAll
replaceFirst          split                 startsWith            subSequence
substring             toCharArray           toLowerCase           toString
toUpperCase           trim
```
Step 3. Define some functions
-----------------------------
```
scala> def max(x: Int, y: Int): Int = {
     |   if (x > y) x
     |   else y
     | }
max: (x: Int, y: Int)Int
```

- 関数のパラメータ型には型推論を行わないので型アノテーションがマスト
- **result type 結果型**

```
scala> def max2(x: Int, y: Int) = if (x > y) x else y
max2: (x: Int, y: Int)Int
```

- 1文なら`{}`を省略できる
- **再帰的**関数出ない場合は結果型は型推論してくれる
  - しかし、書いておいたほうがbetter

```
scala> def greet() = println("Happy Vimming!")
greet: ()Unit
```

- `Unit`というresult typeは関数が意味ある値を返してこないことを指す
- `void`に似ている
- `Unit`のメソッドは**side effects**のためにのみ実行される


Step 4. Write some Scala scripts
--------------------------------

helloargs.scala

```
println("Hello, " + args(0) + "!")
```

- 添字は`(\d)`
- プログラムのコマンド行引数は`args`という名前のScala配列を介してアクセスできる

Step 5. Loop with while; decide with if
---------------------------------------
```
var i = 0
while (i < args.length) {
  println(args(i))
  i += 1
}
```

- Scalaの推奨インデントはスペース2個分
- `i++`などは使えない

```
var i = 0
while (i < args.length) {
  if (i != 0)
    print(" ")
      print(args(i))
      i += 1
}
println()
```

- println -> print line
- print もある

Step 6. Iterate with foreach and for
------------------------------------

`while` loopはimperative style

-> functional styleへ

```
args.foreach(arg => println(arg))
```

- `arg`が引数の関数リテラル: `arg => println(arg)`

引数が1文から構成される場合は、引数を明示的に指定しなくて済む -> **partially applied function** 部分適用された関数 c.f. 8.6

### 関数リテラル
```
({parameters})   => {body}
(x: Int, y: Int) => x + y
```

### for式 c.f. 7.3 && 23

```
for (arg <- args)
  println(arg)
```

`<-`をinと読めば `for arg in args` となる

`val arg`と同じ意味になって、ループごとに新しいvalのargが作られる
