object Task2 {
////////////////////////////////////////////////////////////////////////////////////////////////////////////
  class ToDoItem(val taskName : String,val date : String){
    private var done = false

    override def toString: String = f"${taskName} - till ${date} | DONE: ${done}"
    def markAsDone(){done = true}
    def isDone: Boolean= done
  }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
  class ToDoList{
    var list2 : List[ToDoItem] = _

    def +(item : ToDoItem): Unit =   list2 = if(list2 == null) List(item) else list2 ::: List(item)

    override def toString: String = {
      var result = ""
      for(x <- list2) result += x + "\n"
      result
    }

    def markAsDone(n : Int): Unit = {
      list2.apply(n).markAsDone()
      removeAllDone()
    }

    def removeAllDone(): Unit =   list2 = list2.filter(!_.isDone)
  }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////


  def main(args: Array[String]): Unit = {
    val toDoList = new ToDoList()

    toDoList + new ToDoItem("Clean carpet", "2020-11-01")
    toDoList + new ToDoItem("Wash dishes", "2020-11-02")
    toDoList + new ToDoItem("Learn Scala and be professional with it", "2020-10-28")
    println(toDoList)
    // Prints list of all three ToDoItems nicely formatted, each in separate line
    toDoList.markAsDone(0)
    println(toDoList)
    // Prints list of two ToDoItems without the first one
  }
}
