Chapter 11 Scala's Hierarchy
============================

- すべてのクラスが`Any`のサブクラス
- 階層の最下部に`Null`クラスと`Nothing`クラス

11.1 Scala's class hierarchy
----------------------------
### Any
- Scalaクラスの頂点

```
final def ==(that: Any): Bloolean
final def !=(that: Any: Boolean
def equals(that: Any): Boolean
def ##: Int
def hashCode: Int
def toString: String
```

- Any
  - AnyVal : すべての組み込み値クラス value classes の親
    - [Byte, Short, Char, Int, Long, Float, Double, Boolean, Unit] : これらはすべてリテラルとして書ける
  - AnyRef : 参照クラス reference classes の基底クラス
    - java.lang.Objectクラスの別名にすぎない
    - > Class `AnyRef` is the root class of all ''reference types''.

11.2 How primitives are implemented
-----------------------------------
- auto-boxing: 値型と参照型との間での自動変換
- 「バックアップ」クラス
- 参照透過性: 参照先が同じであること
- ハッシュコンス hasdh-conding: リストオブジェクトなどの記号化表現

11.3 Bottom types
-----------------
- scala.Null
- scala.Nothing
