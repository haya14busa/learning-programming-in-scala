val firstArg = if (!args.isEmpty) args(0) else ""
val friend = {
  firstArg match {
    case "salt" => "pepper"
    case "chips" => "salsa"
    case "eggs" => "bacon"
    case _ => "hun?"
  }
}

println(friend)
