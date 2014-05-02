Chapter 13 Packages and Imports
===============================

- 結合度: coupling
- 部品: parts
- 実装: Implementation
- インターフェイス: interface

13.1 Putting code in packages
-----------------------------
- 今までのコードは無名 **unnamed** パッケージに含まれていた
- ファイルの冒頭に`package`節を書けばファイル全体の内容がパッケージにまとめられる

```
package bobsrockets.navigation
class Navigator
```

### Caveat
- Package名はJavaの逆ドメイン名方式に従った方がよい
- `com.bobsrockets.navigation`

### packaging
```
package bobsrockets.navigation {
  class Navigator
}
```

### 同一ファイル内に複数パッケージ
```
package bobsrockets {
  package navigation {
    // bobsrockets.navigation package
    class Navigator
    package tests {
      // bobsrockets.navigation.tests package
      class NavigatorSuite
    }
  }
}
```

13.2 Concise access to related code
-----------------------------------

- 中括弧でネストせず複数のpackage節を使う -> Chained Package Clauses 連鎖パッケージ節

```
package bobsrockets
package fleets
class Fleet {
  def addShip() { new Ship }
}
```

- あらゆる外側のパッケージとして`_root_`という名前のパッケージが用意されている

13.3 Imports
------------
- 完全修飾された名前ではなく、単純名でアクセスできるようになる

```
import bobsdelights.Fruits
import bobsdelights._
import bobsdelights.Fruits._
```

- 単一型 single type import
- オンデマンド on-demand import

- 任意の場所でimport可能
- c.f. 29

### flexible
- 任意の場所にかける
- パッケージのほか、オブジェクト(シングルトンでも通常でも)も参照できる
- インポートされたメンバーの一部の名前を変えたり、隠したりできる


### import selector clause
- インポートセレクター節

```
import Fruiits.{Apple, Orange}
```

名称の変更

```
import Fruiits.{Apple => McIntosh, Orange}
// <元の名前> => <変更後の名前>
```

### Example

```
import java.sql.{Date => SDate}
import java.{sql => S}
// S.Date
import Fruits.{_}
// == import Fruits._
import Fruits.{Apple => McIntosh, _}
import Fruits.{Pear => _, _}
// Pearを除くFruitsのすべてのメンバをインポートする
```

- 単純名の `x`
- 名称変更の `x => y`
- 隠蔽節の `x => _`
- chatch-all節の `_`

13.4 Implicit imports
---------------------
Scalaは暗黙のうちにすべてのプログラムにいくつかのインポート文を追加している。
`.scala`という拡張子をつけた場合

```
import java.lang._
import scala._
import Predef._
```

13.5 Access modifiers
---------------------
- package, class, object のメンバーには`private`, `protected`という**access modifiers** アクセス修飾子をつけることができる

### 13.5.1 非公開(private) メンバー
- そのメンバー定義を含んでいるクラスやオブジェクトの中からしか見えなくなる

### 13.5.2 限定公開(protected) メンバー
- メンバーが定義されているクラスのサブクラスでなければアクセスできない

### 13.5.3 公開(public)メンバー
- デフォルト
- 任意の場所からアクセス可能

### 13.5.4 アクセス保護のスコープ
- `private[X]`, `protected[X]`

### object-private オブジェクト非公開
- `private[this]`
- その定義を含むオブジェクトの中からしかアクセスできない
- 変位 variance 指定アノテーションを指定できるようにするために使われることも c.f. 19.7


```
val other = new Navigator
other.speed // Error
```

### 13.5.5 可視性とコンパニオンオブジェクト
- クラスとコンパニオンオブジェクトは互いにアクセス権を共有する


13.6 Package objects
--------------------
- ヘルパーメソッドなどもトップレベルにおける
- そのためにはパッケージオブジェクトに定義を配置する
- 個々のパッケージはひとつずつパッケージオブジェクトを持てる



