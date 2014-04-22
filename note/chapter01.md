Chapter 01
==========

- Scala is Scalable Language
- Scalaはスカラと読む。スカーラじゃない!!!
- Object Oriented Programmin meets Functional Programming

1.1
---
- `Map("key" -> "value")`
- HashMap, TreeMap
- **trait** トレイト
  - [traitの意味・用例｜英辞郎 on the WEB：アルク](http://eow.alc.co.jp/search?q=trait)
- **mixin** ミックスイン

1.1.1
-----
- 伽藍とバザール
- Scalaはバザールより
- `BigInt`は標準ライブラリでネイティブでない

1.1.2
-----

### Actor
- Erlangで使われている
- 並行プログラミング
- 送信と受信
  - 送信: `!`
- actore, loop, receive, `!`はScalaのアクター標準ライブラリによるもの

1.2 The Reason Why Scala has scalability
------------------------------------
- Scalaのスケーラビリティはオブジェクト指向と関数型プログラミングの結合によって実現されている

1.2.1 Scala is Object Oriented
------------------------------
- 構造
- データと操作を結合
- Smalltalk (作者: Alan Kay)
- Scalaは純粋なオブジェクト指向言語
  - `Int`もオブジェクト
  - `!`は`Actor`クラスのメソッド

### Trait トレイト
- method実装、フィールドを持てる
- ダイヤモンド継承問題を回避できる
  - [菱形継承問題 - Wikipedia](http://ja.wikipedia.org/wiki/%E8%8F%B1%E5%BD%A2%E7%B6%99%E6%89%BF%E5%95%8F%E9%A1%8C)

### Mixin Composition ミックスイン合成
- 1つのクラスのメンバーをもとに、それにトレイト(複数可)のメンバーを追加すること

1.2.2 Scala is Functional Programming Language
----------------------------------------------

### 関数型プログラミングとは
1. 関数がfirst-class values
  - `Int`などと同じように定義したり, 引数として渡せたり, 代入できたり, etc...
  - c/C++ではsecond-class
2. **「プログラム内の操作は、データをその場で書き換えるのではなく、入力の値を出力の値にマップ(写像)すべき」**
  - Rubyの文字列はmutableだが、ScalaやJavaではImmutable
  - In other words, 「メソッドはどんな**副作用(side effect)**も持ってはならない」
  - **Referencial Transparent 参照透明**
  - <-> imperative style 命令型

1.3 Why Scala?
--------------

1. スケーラビリティ
2. 互換性
3. 簡潔さ
4. 高水準の抽象
5. 高度な静的型付け

1.3.1 互換性(Javaとの共存)
--------------------------
- グルーコード(接着用コード)なしでJavaの資産をつかえる
- ScalaはJavaの型を再利用してる
- **暗黙の型変換 Implicit Conversion**
  - Javaの型をこれによってドレスアップできる

1.3.2 簡潔性
------------

```scala
class Myclass(var index: Int, var name: String) {}
```
Scalaで作ったイスタンス変数は再代入不能 -> 再代入するにはc.f. 10.6

型推論

1.3.3 高水準
------------

```
val nameHasUpperCase = name.exists(_.isUpper)
```
XXX: name?

- **述語関数(predicate)**
- `_.isUpper`は述語関数
- 結果型が`Boolean`になる関数リテラルは述語関数と呼べる
- `_`アンダースコアを引数のプレースホルダーとして使える -> c.f. 8.5

1.3.4 静的な型付け
------------------
- 簡潔性
- 柔軟性
- 検証可能性
- 安全性
- ドキュメント性

### generic ジェネリック
型をパラメータ化 c.f. 19

### intersection 論理積
型を結合 c.f. 12

### abstract type 抽象型
型の詳細を隠蔽 c.f. 20

### 静的型付けの問題点
1. 冗長性
  - 型推論(Type Inference)によって解消
2. 柔軟性のなさ
  - パターンマチング、型を記述したり合成する新たな方法で回避

### 検証可能な性質
- ある種のランタイムエラーが存在しないことを証明

> 「単体テストが証明するのはエラーの存在であって、エラーの不在ではない」
> Program testing can be used to show the presence of bugs, but never to show their absence!

>  - Edsger Dijkstra, "Notes on Structured Programming"

- [エドガー・ダイクストラ - Wikipedia](http://ja.wikipedia.org/wiki/%E3%82%A8%E3%83%89%E3%82%AC%E3%83%BC%E3%83%BB%E3%83%80%E3%82%A4%E3%82%AF%E3%82%B9%E3%83%88%E3%83%A9)
- [Edsger W. Dijkstra - Wikiquote](http://en.wikiquote.org/wiki/Edsger_W._Dijkstra)


### 安全なリファクタリング
セーフティーネットを提供

### ドキュメント性
- 型アノテーションはドキュメント

ドキュメント性がある。引数として`String`を取らなければならないことがわかる
```
def f(x: String) = ...
```

冗長な例
```
val x: HashMap[Int, String] = new HashMap[Int, String]()
```

改善した例(型推論)
```
val x = new HashMap[Int, String]()
val x: Map[Int, String] = new HashMap()
```

1.4 Scala's roots
-----------------

- 型アノテーションが後置(Javaと違う)
  - 型推論しやすい
- [ML (プログラミング言語) - Wikipedia](http://ja.wikipedia.org/wiki/ML_(%E3%83%97%E3%83%AD%E3%82%B0%E3%83%A9%E3%83%9F%E3%83%B3%E3%82%B0%E8%A8%80%E8%AA%9E))

### Scalaが提供
- abstract type 抽象型
  - ジェネリック型をよりオブジェクト指向的に
- trait
  - 柔軟なコンポーネントの組み立てを実現
- extractor 抽出子
  - 表現に依存しないパターンマッチを提供

### Conclusion
Scalaはオブジェクト指向と関数型プログラミングを組み合わせ,強力な静的型付を備えていて最強にみえる。

XXX: 悪いところは? コンパイルの遅さ
