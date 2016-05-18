

trait ModXmlGeneratorNew extends Notes{

  def generateXml = {

    generateNotes

  }

/*
  override def editorNote = {
    print("Editor Note in base@@@")
  }

  override def authorNote = {
    print("Author Note in base@@@")
  }
*/


}

trait Notes extends AuthorNode with EditorNode {
  def generateNotes = {
    editorNote
    authorNote
  }
}

trait EditorNode {
  def editorNote = {
    print("Editor note in trait EditorNote")
  }
}
trait AuthorNode {
  def authorNote = {
    print("Author note in trait AuthorNode")
  }
}

class IspModXmlGeneratorNew extends ModXmlGeneratorNew with Notes {
  override def generateNotes = {
    editorNote
  }
}


(new IspModXmlGeneratorNew()).generateXml