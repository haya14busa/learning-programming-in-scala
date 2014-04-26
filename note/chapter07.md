Chapter 07 Built-in Control Structures
======================================

- if
- while
- for
- try
- match

7.1 If expressions
------------------
- if は値を返す
- 3項演算子のかわり

### val のメリット
- equational reasoning 等式推論をサポートしやすい

7.2 While loops
---------------
- 式ではなくループ
- 値を得られないから
- 結果型はUnit

### Unit Type
- `()` というただひとつの値をもってる
- この点で`void`とは違う

### Caveat: while loops
- while loopは値を持たないので、純粋関数型言語では取り除かれることも
- var と同じく避けたほうがよい

7.3 For expressions
-------------------
[アーミーナイフ - Wikipedia](http://ja.wikipedia.org/wiki/%E3%82%A2%E3%83%BC%E3%83%9F%E3%83%BC%E3%83%8A%E3%82%A4%E3%83%95)

反復処理のスイスアーミーナイフ

### 7.3.1 コレクションの反復処理
```
val filesHere = (new java.io.File(".")).listFiles
for(file <- filesHere) {
  println(file)
}
```

- `file <- filesHere`: Generator ジェネレータ
- `1 until 4`: 1から3

### 7.3.2 フィルタリング
```
val filesHere = (new java.io.File(".")).listFiles
for(file <- filesHere if file.getName.endsWith(".scala")) {
  println(file)
}
```

- if を後置してフィルタリングできる

### 7.3.3 入れ子の反復処理

### 7.3.4 変数への中間結果の束縛
- 束縛: bind

### 7.3.5 新しいコレクションの作成
- Iteration後も保持する
- `yield`

for: c.f. 23

7.4 Exception handling with try expressions
-------------------------------------------

### 7.4.1 例外のスロー
```
throw new IllegalArgumentException
```

- throwは結果型を持つ式で`Nothing`を返す


```
def half(n: Int): Int = {
  if (n % 2 == 0) {
    n / 2
  } else {
    throw new RuntimeException("n must be even")
  }
}

println(half(4))
println(half(5))
```

### 7.4.2 例外のキャッチ
- catch
- パターンマッチ pattern match統一性
- `@throws` アノテーション c.f. 31.2

### 7.4.3 finally節
- ローンパターン c.f. 9.4

### 7.4.4 値の生成
- try-catch-finallyは結果値を生成する

```
scala> def f(): Int = try { return 1 } finally { return 2 }
f: ()Int

scala> f
res0: Int = 2

scala> def g(): Int = try { 1 } finally { 2 }
<console>:7: warning: a pure expression does nothing in statement position; you may be omitting necessary parentheses
       def g(): Int = try { 1 } finally { 2 }
                                          ^
g: ()Int

scala> g
res1: Int = 1
```

基本的にfinallyで値は返さない!

7.5 Match expressions
---------------------
- similar to `switch`
- `_` アンダースコアはよくわからない値のためのプレースホルダー c.f. 8.5
- `break`いらない
- 結果値を生成する

7.6 Living without break and continue
-------------------------------------
- breakやcontinueは関数リテラルと相性が悪い
- break -> if
- continue -> Boolean

どうしてもbreakしたかったら`scala.util.control.Breaks._`を使う

7.7 Variable scope
------------------
- `{}`の中で定義されたものは、`}`のあとからはスコープを外れる
  - forの代替としての`{}`など例外もある
- shadow シャドウイング: スコープの内側で外側と同じ名前の変数を定義できる

```
val a = 1;
{
  val a = 2
  println(a)
}
println(a)
```

7.8 Refactoring imperative-style code
-------------------------------------
- 副作用のない関数は単体テストがしやすい
