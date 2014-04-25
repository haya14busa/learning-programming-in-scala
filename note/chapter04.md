Chapter 04 Class and Objects
============================

4.1 Classes, fields, and methods
--------------------------------

- Class は Object の青写真

クラス定義

- member
  - field:
    - オブジェクトを参照する変数。`val` or `var` で定義
    - オブジェクトの*状態*や*データ*を保持
    - インスタンス変数: instance variables
  - method: 実行可能なコードを格納する。 `def` で定義
    - fieldを使った、オブジェクトがするべき仕事を実行する

`new`するとインスタンスが作られ、メモリが確保される

### fieldを非公開に
- 非公開: private
- 外部からアクセスできない
- オブジェクトのメソッドからはアクセス可能

定義方法: アクセス修飾子 access modifiers, `private`を挿入する

```
class ChecksumAccumulator {
  private var sum = 0
}

val acc = new ChecksumAccumulator
acc.sum = 5 // Error
```

`private` <-> `public` でデフォルトは`public`


```
class ChecksumAccumulator {
  private var sum = 0
  def add(b: Byte): Unit = {
      sum += b
  }
  def checksum(): Int = {
    return ~(sum & 0xFF) + 1
  }
}
```

- メソッドパラメータは`val`
- `return`は明示しなければ最後の値が返される
  - return文は1つにすることを推奨
- メソッド宣言で`=`がないと結果型が`Unit`になり、期待した値が返却されない

4.2 Semicolon inference
-----------------------
`;`で1行に複数文かける

```
val s = "hello"; println(s)
```

`()`で囲めば確実に1文として扱われる

```
(x
+ y)
```

Better

```
x +
y
```

Scalaでは行末に中置演算子を置くことを推奨


4.3 Singleton objects
---------------------
- 静的メンバ static member は持てない
- シングルトンオブジェクト singleton objects を持っている

### companion objects
- シングルトンオブジェクトがクラスと同じ名前を持つ -> コンパニオンオブジェクト companion objects
- 同じソースファイルで定義しなければならない
- そのクラスは コンパニオンクラス companion class と呼ぶ
- お互いに非公開メンバにアクセスできる

### cache
- cacheには`scala.collection.mutable.WeakHashMap`という弱いマップを使うべき
- メモリが減るとGarbage CollectionCされる

### Checksum
- [チェックサム - Wikipedia](http://ja.wikipedia.org/wiki/%E3%83%81%E3%82%A7%E3%83%83%E3%82%AF%E3%82%B5%E3%83%A0)
- [チェックサムとは 【 check sum 】 - 意味/解説/説明/定義 ： IT用語辞典](http://e-words.jp/w/E38381E382A7E38383E382AFE382B5E383A0.html)



- companion objectsはパラメータを取れない。(new できない)
- 自動生成クラス synthesis class のインスタンスとして実装される

自動生成クラスの名前は"オブジェクト名+$" (ChecksumAccumulator$)

### standalone objects
- コンパニオンクラスと同じ名前を共有しないシングルトンオブジェクトは、スタンドアロンオブジェクトと呼ばれる
- 使用例:
  - ユーティリティメソッドのコレクション
  - エントリーポイント

4.4 A Scala application
-----------------------
Scalaプログラムを実行するには`main`メソッドを持つstandalone objectの名前を指定しなければならない。

### main method
- Parameter: `Array[String]`
- Result Type: `Unit`

### 暗黙のImport
- `java.lang`
- scala パッケージのメンバー
- `Predef`
  - `println`, `assert`など

ファイル名と公開クラスの名前は違っても良いが、同様にすることを推奨

### scalac重い
- `jar`ファイルの内容をスキャンするなどの初期作業が長い
- fsc: fast Scala compiler を使う
- 初回にデーモンを立ち上げるので、その後が速くなる
- 終了するには `fsc -shutdown`

### 実行
- 正しいシグネチャーの`main`メソッドを格納するスタンドアロンオブジェクトの名前を指定

```
# scala Summer of love
of: -213
love: -182
```

4.5 The Application trait
-------------------------
Scalaは`scala.Application`というトレイトを提供しており、これによってコード入力を少しでも減らそうとしている

後にもっと詳しく説明あり

**Scala 2.9以降はscala.Applicationトレイトは非推奨で、scala.Appトレイトが推奨**

```
import ChecksumAccumulator.calculate
object FallWinterSpringSummer extends App {
  for(season <- List("fall", "winter", "spring")) {
    println(season + ": " + calculate(season))
  }
}
```

### 使い方
- `main`メソッドのかわりに`extends App`
- コンパイル -> 実行できる
- Appトレイトが正しいシグネチャーの`main`メソッドを宣言しており、それを継承しているから動作する
- 基本コンストラクター primary constructors

### 欠点
- `args`配列にアクセスできない
- マルチスレッドプログラムでは明示的に`main`メソッドを書く必要あり
- 最適化がされない

-> 単純かつシングルスレッドの時のみ使用するべき

!!! `App` traitでは`args`にアクセスできる

```
// File: Summer2.scala
import ChecksumAccumulator.calculate

object Summer2 extends App{
  for(arg <- args) {
    println(arg + ": " + calculate(arg))
  }
}
```
