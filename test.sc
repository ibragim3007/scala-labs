abstract class ComputerTech {
  protected var nameTech: String
  protected var priceTech: Int
  def devicesAbout (): Unit
  def defaultInfoPrint(): Unit = {
    println("Название техники: " + nameTech)
    println("Цена техники: " + priceTech)
  }
  def printInfo (): Unit = {
    defaultInfoPrint()
  }
  def getName: String = nameTech
  def getPrice: Int = priceTech
}


class Printer (var nameTech: String, var priceTech: Int) extends ComputerTech {
  protected var ColorStatusHave = 100
  override def devicesAbout (): Unit = print("Это принтер!")

  def printSomething(): Unit = {
    println("Print This")
    ColorStatusHave = ColorStatusHave - 1
  }
}


class Computer (var nameTech: String, var priceTech: Int) extends ComputerTech {
  override def devicesAbout() : Unit = print("Это компьютер!")
}

abstract class DiskLogic (var nameTech: String, var priceTech: Int, var storageSize: Double)
  extends ComputerTech {
  var textInStorage: String

  override def printInfo(): Unit = {
    defaultInfoPrint()
    println("Размер хранилища: " + storageSize)
  }

  def writeTextInStorage(text: String): Unit = {
    if (text.length <= storageSize) textInStorage = text
    else println("Не достаточно места!")
  }
  def getTextInStorage: String = textInStorage
}


class RemovableDrive (var nameRemovableDrive: String, var priceRemovableDrive: Int, var storage: Double)
  extends DiskLogic(nameRemovableDrive, priceRemovableDrive, storage)
{
  override var textInStorage = ""
  override def devicesAbout(): Unit = print("Это съемный диск!")
}


class Keyboard (var nameKeyboard: String, var priceKeyboard: Int, var weight: Int)
  extends Computer (nameKeyboard, priceKeyboard)
{
  override def devicesAbout(): Unit = print("Это клавиатура!")
  override def printInfo(): Unit = {
    defaultInfoPrint()
    println("Вес: " + weight)
  }
}


class audioSpeakers (var nameAudioSpeakers: String, var priceAudioSpeakers: Int)
  extends Computer (nameAudioSpeakers, priceAudioSpeakers)
{
  private val connectionSound = "Blumbp..."
  override def defaultInfoPrint(): Unit = print("Это аудоколонки!")

  override def printInfo(): Unit = {
    defaultInfoPrint()
    println("Звук подключения: " + connectionSound)
  }

  def Connection(): Unit = {
    println(connectionSound)
  }
}


class Motherboard (var nameMotherboard: String, var priceMotherboard: Int)
  extends Computer (nameMotherboard, priceMotherboard)
{
  override def devicesAbout(): Unit = print("Это материнская плата!")
}


class Processor (var nameProcssor: String, var priceProseccor: Int, var power: Double)
  extends Motherboard (nameProcssor, priceProseccor)
{
  override def devicesAbout(): Unit = print("Это процессор!")
  override def printInfo(): Unit = {
    defaultInfoPrint()
    println(power)
  }
}


class MemoryDevice (var nameMemoryDevice: String, var priceMemoryDevice: Int, var storage: Double)
  extends DiskLogic (nameMemoryDevice, priceMemoryDevice, storage)
{
  override var textInStorage: String = ""
  override def devicesAbout(): Unit = print("Это запоминающее устройство!")
}


class HDD (var nameHDD: String, var priceHDD: Int, var storage: Double)
  extends DiskLogic (nameHDD, priceHDD, storage) {
  var textInStorage: String = ""
  override def devicesAbout(): Unit = print("Это жесткий диск!")
}

class HDDwithResourse (var nameHDD: String, var priceHDD: Int, var storage: Double)
  extends DiskLogic(nameHDD, priceHDD, storage)
{
  private var resourse: Int = 5
  var textInStorage: String = ""
  override def devicesAbout(): Unit = print("Это жесткий диск с ресурсом!")

  override def writeTextInStorage(text: String): Unit = {
    if (resourse > 0) {
      resourse = resourse - 1
      if (text.length < storage) writeTextInStorage(text)
    } else print("Ресурс использован!")
  }
}


var myPc: Computer = new Computer("IBM", 1_000_000)
myPc.printInfo()

var a: Printer = new Printer("Lenovo 1.23", 23_000)

val motherboard = new Motherboard("ASUS B350", 11_000)
motherboard.printInfo()

val opera = new MemoryDevice("Samsung g256gb", 4_000,  10)
opera.defaultInfoPrint()
opera.writeTextInStorage("Hello")
print(opera.getTextInStorage)

var romv = new RemovableDrive("Toyata 252", 25_250, 150)
romv.writeTextInStorage("Hello world how are you!")
romv.printInfo()

var diskRes = new HDDwithResourse("Toshiba 2tb", 10_320, 5)
diskRes.writeTextInStorage("Hello1")
diskRes.writeTextInStorage("Hello2")
diskRes.writeTextInStorage("Hello3")
diskRes.writeTextInStorage("Hello4")
diskRes.writeTextInStorage("Hello5")
diskRes.writeTextInStorage("Hello6")
print(opera.priceMemoryDevice)

