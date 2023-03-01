package uz.gita.testapp.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import uz.gita.testapp.model.Answer;
import uz.gita.testapp.model.TestData;

public class AppController {
    private List<TestData> list;

    public List<TestData> getList() {
        return list;
    }

    private final int MAX_COUNT = 20;

    private int currentPosition;

    private int wrongAnswerCount;
    private int correctAnswerCount;

    public void setWrongAnswerCount(int wrongAnswerCount) {
        this.wrongAnswerCount = wrongAnswerCount;
    }

    public void setCorrectAnswerCount(int correctAnswerCount) {
        this.correctAnswerCount = correctAnswerCount;
    }

    public int getMAX_COUNT() {
        return MAX_COUNT;
    }


    public Answer answer;

    {
        loadTest();
    }

    public List<Answer> correctAnswerByPosition = new ArrayList<>();

    public int getCurrentPosition() {
        return currentPosition;
    }

    public int getWrongAnswerCount() {
        return wrongAnswerCount;
    }

    public int getCorrectAnswerCount() {
        return correctAnswerCount;
    }

    private AppController() {

    }

    public static AppController controller;

    public static AppController getInstance() {
        if (controller == null) {
            controller = new AppController();
        }
        return controller;
    }

    private void loadTest() {
        list = new ArrayList<>(5);
        list.add(new TestData("“Alpamıs” da'stanında qaysı obraz tilinen aytılg'an qatarlar?\n" +
                "Ay qaran'g'ı ko'rinip tur ko'zlerge,\n" +
                "Sawıtlar jetpeydi igri dizlerge, Qon'ırattan bir jigit kelip tur izlep, Eglenbey su'yinshi berin' bizlerge.", "Qarajan", "Ko'kaman", "Shekaman", " Ashim", "Qarajan"));

        list.add(new TestData("To'mendegi qatarlarda qaysı qaharman haqqında aytılg'an?\nJılqı semiz bolg'anda,\n" +
                "Asırandı ulın'ız\n,Jılqı arıq bolg'anda,\nSatıp alg'an qulın'ız.", "Edige", "Qoblan", "Ma'spatsha", "Sha'ryar", "Edige"));

        list.add(new TestData("Qaraqalpaq xalqının' Tu'rkstannan Xorezmge ko'shiw waqıyasın so'z etiwshi shıg'arma qaysı juwapta berilgen?", "Xalıq qa'ytip ku'n ko'rer", "Ju'regimde ko'p dag'ım", "Aldı-artım biyik jar", "Posqan el", "Posqan el"));

        list.add(new TestData("XIX a'sirde Molla Moyın ta'repinen qaraqalpaq tiline awdarılg'an kitap qaysı juwapta berilgen?", "Al asar albakiya al alkuran al xaliya", "Shaxnama", "Avesto", "Gu'listan", "Shaxnama"));

        list.add(new TestData("Xalıqtın' bir wa'kili sıpatında soralg'an to'mendegi u'sh o'tinish qaysı do'retpede berilgenin anıqlan?\nBirinshi − puldın' q'adirin k'obeyt.\n" +
                "Ekinshisi − xalıq ushın za'ru'r bolg'an  adalatlı zan'lardı shı ́gar.\n" +
                "U'shinshisi − jollardı qaraqshılardan qorg'a.", "Haqıyqatlar sıylıg'ı", "Diywanı Hikmet", "Baxıtqa baslawshı bilim", "Devani lug'atit at-tu'rk", "Baxıtqa baslawshı bilim"));

        list.add(new TestData("O'z do'retpelerinde “Jaz ku'nlerim boldı gu'zek” degen metonimiya arqalı o'zinin' awır keshirmesin, “Tapqanım jetpey jutımg'a” degen litota arqalı adam miynetinin' arzanlıg'ın ko'rkem sa'wlelendirgen shayırdı anıqlan ?", "Berdaq G'arg'abay ulı", "Ku'nxoja Ibrayım ulı", " Otesh Alshınbay ulı", " A√jiniyaz Qosıbay ulı", "Ku'nxoja Ibrayım ulı"));

        list.add(new TestData("Omar shayır o'zinin' qaysı qosıg'ında Qazalıda kuni-tu'ni tınbay on segiz adam bolıp jumıs islegenligin, zalımlardın' tamaq bermegenligin so'z etedi?","Kerek emes","Ayırsha","Ne payda?","Elim","Ne payda?"));

        list.add(new TestData("“Bag'dagu'l” dramasının avtorı kim?","Q.A'wezov","S.Ma'jitov","A'.O'tepov","J.Aymurzaev","S.M'ajitov"));

        list.add(new TestData("Arqashtag'ı ko'lge kelip, uzaq oylanıp otıratug'́ın ulın duwalamawın sol ko'lde bar dep isengen suw perisinen sorang'an ana obrazı qaysı shıg'arma syujetinde ushırasadı?","Mug'allimge raxmet","Ja'miyla","Jiyren","Bu'lbu'l uyası","Bu'lbu'l uyası"));

        list.add(new TestData("Aspang'a usharsan', bolsa qanatın,\n" +
                "Shad bolarsan', shadlı bolsa elatın.\n" +
                "Bul ushırma so'zler kimnin' qosıq qatarlarınan alıng'an?","A'jiniyaz Qosıbay ulı","Berdaq shayır","Ku'nxoja Ibrayım ulı","O'tesh shayır","Ku'nxoja Ibrayım ulı"));

        list.add(new TestData("Rısjan to'mendegilerden qay biri menen aytısqan?","Sulıwxan","Ayxan","Gu'lxan","Da'metken","Gulxan"));

        list.add(new TestData("O'zbekistan Qaharmanı A.O'teniyazovqa arnap jazılg'an shıg'arma qaysı qatarda berilgen?","Shaqasında emes tamırında","Tag'dir","Birinshi patefon","Er basına is tu'sse","Shaqasında emes tamırında"));

        list.add(new TestData("Qaysı qaraqalpaq shayırı Qazaqstandag'ı Orenburg qalasındag'ı  a'skeriy mektepte bilim al'gan?","N.Da'wqaraev","I.Fazılov","Q.A'wezov","A.Bekimbetov","I.Fazılov"));

        list.add(new TestData("Jazıwshı O.A'bdiraxmanovqa 1985-jılı YUNESKO medalı berildi. Qaysı shıg'arması ushın?","Mırzanın ́ izi","Qon'ırat soda zavodı","Bosag'a","Aralım − da'rtim menin'”","Aralım − da'rtim menin'”"));

        list.add(new TestData("At ornına arqan tag'ıp,\n" +
                "Jolbarıstı jegip bolmas,\n" +
                "Awzın' qang'a tolsadag'ı,\n" +
                "Jaw aldında to'gip bolmas...","“Tumaris” poemasınan","“Bahadır” da'stanınan","Edige” da'stanınan","“Amangeldi” da'stanınan","“Tumaris” poemasınan"));

        list.add(new TestData("Tawday eken ol zan'g'ardın ́ ju'rekleri,\n" +
                "Qos nayzag'a qumar eken bilekleri,\n" +
                "Bala mag'an juwırdı attan tu'sip,\n" +
                "Sawash eken qudaydan tilekleri.\n" +
                "Qosıq qatarları qaysı da'stannan ha'm qaysı qaharmang'a qarata aytılg'an?","“Qırq qız” da'stanında Otbasqang'a","“Alpamıs” da'stanında Alpamısqa","“Edige” da'stanında Nuratdinge","“Qoblan” da'stanında Ersayımg'a","“Alpamıs” da'stanında Alpamısqa"));

        list.add(new TestData("Buwınnın' qaysı tu'ri rus tili ha'm rus tili arqalı basqa tillerden kirgen ayırım so'zlerdin' ortasında keledi?","tuyıq buwın","qamaw buwın","aralas buwın","ashıq buwın","ashıq buwın"));

        list.add(new TestData("Bulardın' so'zi meni otırg'an ornımnan turg'ızdı. Berilgen ga'pte tartım jalg'awlı so'z neshew?","3","2","4","1","2"));

        list.add(new TestData("Ken'eytilgen jay ga'pti tabın'?","Bizler Oksana ekewimiz otırmız.","Japıraqlar jım-jırt.","Aspan a'leminde aqshıl bultlar ko'rindi.","Kewlim alag'ada bola berdi.","Aspan a'leminde aqshıl bultlar ko'rindi."));

        list.add(new TestData("Qaraqalpaq folklorlıq shıg'armalarının' ishinde jetekshi orındı iyeleytug'ın janr qaysı juwapta berilgen?","qosıq","da'stan","ertek","salt-da'stur jırları","ertek"));

        shuffle();
    }

    private void shuffle() {
        Collections.shuffle(list);
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }

    public TestData getNextData() {
        return list.get(currentPosition++);
    }

    public void check(String userAnswer) {
        if (list.get(currentPosition - 1).getAnswer().equals(userAnswer)) {
            correctAnswerCount++;
            correctAnswerByPosition.add(new Answer(1, currentPosition - 1));
        } else {
            wrongAnswerCount++;
            correctAnswerByPosition.add(new Answer(0, currentPosition - 1));

        }
    }

    public boolean isLastQuestion() {
        return currentPosition < MAX_COUNT;
    }

    public int getSkipCount() {
        return currentPosition - correctAnswerCount - wrongAnswerCount;
    }
}
