package cn.itcast

class UserDraw() {
  // 属性// 属性

  private var statTimeDay = ""
  private var MDN = ""
  private var male = 0.0
  private var female = 0.0
  private var age1 = 0.0
  private var age2 = 0.0
  private var age3 = 0.0
  private var age4 = 0.0
  private var age5 = 0.0

  def this( male:Float,female:Float,age1:Float,age2:Float,age3:Float,age4:Float,age5:Float){
     this()
    this.male = male
    this.female = female
    this.age1 = age1
    this.age2 = age2
    this.age3 = age3
    this.age4 = age4
    this.age5 = age5

  }

  // 重写toString
  override def toString: String = {
    val  sb =  new StringBuilder

    sb.append("dsfdsf").append("|").append()
    sb.append(statTimeDay).append("|")
    sb.append(MDN).append("|")

    sb.toString
  }

  // 融合方法
  /** 性别融合 */
  def protraitSex(male2: Double, female2: Double, times: Long): Unit = {
    val sum = this.male + this.female + (male2 + female2) * times
    if (sum != 0) {
      this.male = (this.male + male2 * times) / sum
      this.female = (this.female + female2 * times) / sum
    }
  }

  /** 年龄段融合 */
  def protraitAge(pAge1: Double, pAge2: Double, pAge3: Double, pAge4: Double, pAge5: Double, times: Long): Unit = {
    val sum = age1 + age2 + age3 + age4 + age5 // 之前的APP的 + (pAge1 + pAge2 + pAge3 + pAge4 + pAge5) * times// 当前的APP的
    if (sum != 0) {
      this.age1 = (pAge1 * times + age1) / sum
      this.age2 = (pAge2 * times + age2) / sum
      this.age3 = (pAge3 * times + age3) / sum
      this.age4 = (pAge4 * times + age4) / sum
      this.age5 = (pAge5 * times + age5) / sum
    }
  }

  /** 初始化男女概率 */
  def initSex(male: Float, female: Float): Unit = {
    val sum = male + female
    if (sum != 0) {
      this.male = male / sum
      this.female = female / sum
    }
  }

  /** 初始化年龄段概率 */
  def initAge(pAge1: Float, pAge2: Float, pAge3: Float, pAge4: Float, pAge5: Float): Unit = {
    val sum = pAge1 + pAge2 + pAge3 + pAge4 + pAge5
    if (sum != 0) {
      this.age1 = pAge1 / sum
      this.age2 = pAge2 / sum
      this.age3 = pAge3 / sum
      this.age4 = pAge4 / sum
      this.age5 = pAge5 / sum
    }
  }


  // setter and getter method
  def getStatTimeDay: String = statTimeDay

  def setStatTimeDay(statTimeDay: String): Unit = {
    this.statTimeDay = statTimeDay
  }


  def getMDN: String = MDN

  def setMDN(mDN: String): Unit = {
    MDN = mDN
  }


  def getMale: Double = male

  def getFemale: Double = female

  def getAge1: Double = age1

  def getAge2: Double = age2

  def getAge3: Double = age3

  def getAge4: Double = age4

  def getAge5: Double = age5

}
