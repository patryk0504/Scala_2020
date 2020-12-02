object Task2 {
  def main(args: Array[String]): Unit = {
    //(name, degreeNum, semester, ects, hasExam)
    val subjects = List(
      ("Matematyka dyskretna", 1, 1, 4, false),
      ("Algorytmy i struktury danych", 1, 2, 6, true),
      ("Teoria obwodów i sygnałów", 1, 3, 3, false),
      ("Układy elektroniczne", 1, 4, 5, true),
      ("Bazy danych 1", 1, 5, 5, false),
      ("Inżynieria oprogramowania", 1, 6, 5, true),
      ("Komputeryzacja pomiarów", 1, 7, 3, false),
      ("Modelowanie procesrów fizycznych", 2, 1, 5, true),
      ("Techniki mikroprocesorowe", 2, 2, 5, false),
      ("Programowanie zespołowe", 2, 3, 5, false)
    )
    // list of subjects for bachalor degree
    val subjList = subjects.filter(_._2 == 1)
    println(subjList + "\n")

    // list of subjects for masters degree
    val master = subjects.filter(_._2 == 2)
    println(master + "\n")

    // list of subjects with exams and ECTS > 5
    val examsEcts = subjects.filter(x => x._5 && x._4 > 5)
    println(examsEcts + "\n")

    // list of subjects just with (name, ects)
    val simpleList = subjects.map(x => (x._1,x._4))
    println(simpleList + "\n")

    // list of subjects, where key is number of ECTS and value is list of subjects for that ECTS count (grouped by ECTS)
    val tmp = subjects.groupBy(ects => ects._4)
    println(tmp + "\n")

    // number of ECTS points of all bachalors subjects
    val numEctsBach = subjects.filter(_._2 == 1).map(_._4).sum
    println(numEctsBach + "\n")

    // number of ECTS points of all masters subjects, which doesn't have exam
    val numEctsMast = subjects.filter(x => x._2 == 2 && !x._5).map(_._4).sum
    println(numEctsMast + "\n")

    // sorted list of subjects (by name) for bachalors degree
    val sort = subjects.filter(_._2 == 1).sortBy(_._1)
    println(sort + "\n")
  }
}
