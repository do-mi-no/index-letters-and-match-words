import controllers.LWController;
import models.SampleText;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class AppTest {

    @Test
    public void exampleSentenceKotTest() {
        LWController controller = new LWController();
        doControllerTasks(controller, SampleText.kot);
        ArrayList<String> a_result = new ArrayList<>(Arrays.asList("ala", "javie", "kota", "ma"));
        ArrayList<String> d_result = new ArrayList<>(Arrays.asList("koduje"));
        ArrayList<String> e_result = new ArrayList<>(Arrays.asList("javie", "koduje"));
        ArrayList<String> i_result = new ArrayList<>(Arrays.asList("javie"));
        ArrayList<String> j_result = new ArrayList<>(Arrays.asList("javie", "koduje"));
        ArrayList<String> k_result = new ArrayList<>(Arrays.asList("koduje", "kot", "kota"));
        ArrayList<String> l_result = new ArrayList<>(Arrays.asList("ala"));
        ArrayList<String> m_result = new ArrayList<>(Arrays.asList("ma"));
        ArrayList<String> o_result = new ArrayList<>(Arrays.asList("koduje", "kot", "kota"));
        ArrayList<String> t_result = new ArrayList<>(Arrays.asList("kot", "kota"));
        ArrayList<String> u_result = new ArrayList<>(Arrays.asList("koduje"));
        ArrayList<String> v_result = new ArrayList<>(Arrays.asList("javie"));
        ArrayList<String> w_result = new ArrayList<>(Arrays.asList("w"));

        assertEquals(a_result, controller.getWordsContainingTheLetter("a"));
        assertEquals(d_result, controller.getWordsContainingTheLetter("d"));
        assertEquals(e_result, controller.getWordsContainingTheLetter("e"));
        assertEquals(i_result, controller.getWordsContainingTheLetter("i"));
        assertEquals(j_result, controller.getWordsContainingTheLetter("j"));
        assertEquals(k_result, controller.getWordsContainingTheLetter("k"));
        assertEquals(l_result, controller.getWordsContainingTheLetter("l"));
        assertEquals(m_result, controller.getWordsContainingTheLetter("m"));
        assertEquals(o_result, controller.getWordsContainingTheLetter("o"));
        assertEquals(t_result, controller.getWordsContainingTheLetter("t"));
        assertEquals(u_result, controller.getWordsContainingTheLetter("u"));
        assertEquals(v_result, controller.getWordsContainingTheLetter("v"));
        assertEquals(w_result, controller.getWordsContainingTheLetter("w"));
    }

    @Test
    public void acceptPolishDiactricalCharsTest() {

        LWController controller = new LWController();
        doControllerTasks(controller, SampleText.zolw);

        ArrayList<String> a_result = new ArrayList<>(Arrays.asList("kontentował", "strawą", "trawą", "wraz"));
        ArrayList<String> ą_result = new ArrayList<>(Arrays.asList("strawą", "tą", "trawą"));
        ArrayList<String> b_result = new ArrayList<>(Arrays.asList("żeberko"));
        ArrayList<String> e_result = new ArrayList<>(Arrays.asList("kontentował", "żeberko"));
        ArrayList<String> ę_result = new ArrayList<>(Arrays.asList("się"));
        ArrayList<String> i_result = new ArrayList<>(Arrays.asList("się"));
        ArrayList<String> k_result = new ArrayList<>(Arrays.asList("kontentował", "żeberko"));
        ArrayList<String> ł_result = new ArrayList<>(Arrays.asList("kontentował", "żółw", "żuł"));
        ArrayList<String> n_result = new ArrayList<>(Arrays.asList("kontentował"));
        ArrayList<String> o_result = new ArrayList<>(Arrays.asList("kontentował", "żeberko"));
        ArrayList<String> ó_result = new ArrayList<>(Arrays.asList("żółw"));
        ArrayList<String> r_result = new ArrayList<>(Arrays.asList("strawą", "trawą", "wraz", "żeberko"));
        ArrayList<String> s_result = new ArrayList<>(Arrays.asList("się", "strawą"));
        ArrayList<String> t_result = new ArrayList<>(Arrays.asList("kontentował", "strawą", "tą", "trawą"));
        ArrayList<String> u_result = new ArrayList<>(Arrays.asList("żuł"));
        ArrayList<String> w_result = new ArrayList<>(Arrays.asList("kontentował", "strawą", "trawą", "wraz", "żółw"));
        ArrayList<String> z_result = new ArrayList<>(Arrays.asList("wraz", "z"));
        ArrayList<String> ż_result = new ArrayList<>(Arrays.asList("żeberko", "żółw", "żuł"));

        assertEquals(a_result, controller.getWordsContainingTheLetter("a"));
        assertEquals(ą_result, controller.getWordsContainingTheLetter("ą"));
        assertEquals(b_result, controller.getWordsContainingTheLetter("b"));
        assertEquals(e_result, controller.getWordsContainingTheLetter("e"));
        assertEquals(ę_result, controller.getWordsContainingTheLetter("ę"));
        assertEquals(i_result, controller.getWordsContainingTheLetter("i"));
        assertEquals(k_result, controller.getWordsContainingTheLetter("k"));
        assertEquals(ł_result, controller.getWordsContainingTheLetter("ł"));
        assertEquals(n_result, controller.getWordsContainingTheLetter("n"));
        assertEquals(o_result, controller.getWordsContainingTheLetter("o"));
        assertEquals(ó_result, controller.getWordsContainingTheLetter("ó"));
        assertEquals(r_result, controller.getWordsContainingTheLetter("r"));
        assertEquals(s_result, controller.getWordsContainingTheLetter("s"));
        assertEquals(t_result, controller.getWordsContainingTheLetter("t"));
        assertEquals(u_result, controller.getWordsContainingTheLetter("u"));
        assertEquals(w_result, controller.getWordsContainingTheLetter("w"));
        assertEquals(z_result, controller.getWordsContainingTheLetter("z"));
        assertEquals(ż_result, controller.getWordsContainingTheLetter("ż"));
    }

    @Test
    public void igonoreNonletterCharsTest() {
        String nonLetter = "~!@#$%^&*()_+/*-+ a be ce de";
        LWController controller = new LWController();
        doControllerTasks(controller, nonLetter);

        ArrayList<String> a_result = new ArrayList<>(Arrays.asList("a"));
        ArrayList<String> b_result = new ArrayList<>(Arrays.asList("be"));
        ArrayList<String> c_result = new ArrayList<>(Arrays.asList("ce"));
        ArrayList<String> d_result = new ArrayList<>(Arrays.asList("de"));
        ArrayList<String> e_result = new ArrayList<>(Arrays.asList("be", "ce", "de"));

        assertEquals(a_result, controller.getWordsContainingTheLetter("a"));
        assertEquals(b_result, controller.getWordsContainingTheLetter("b"));
        assertEquals(c_result, controller.getWordsContainingTheLetter("c"));
        assertEquals(d_result, controller.getWordsContainingTheLetter("d"));
        assertEquals(e_result, controller.getWordsContainingTheLetter("e"));

    }

    @Test
    public void igonoreNonletterCharsWithWordsTest() {
        String nonLetter = ")_+/*-+a be#$%^&*\n ~!@(ce,, de..\t";
        LWController controller = new LWController();
        doControllerTasks(controller, nonLetter);

        ArrayList<String> a_result = new ArrayList<>(Arrays.asList("a"));
        ArrayList<String> b_result = new ArrayList<>(Arrays.asList("be"));
        ArrayList<String> c_result = new ArrayList<>(Arrays.asList("ce"));
        ArrayList<String> d_result = new ArrayList<>(Arrays.asList("de"));
        ArrayList<String> e_result = new ArrayList<>(Arrays.asList("be", "ce", "de"));

        assertEquals(a_result, controller.getWordsContainingTheLetter("a"));
        assertEquals(b_result, controller.getWordsContainingTheLetter("b"));
        assertEquals(c_result, controller.getWordsContainingTheLetter("c"));
        assertEquals(d_result, controller.getWordsContainingTheLetter("d"));
        assertEquals(e_result, controller.getWordsContainingTheLetter("e"));

    }

    @Test
    public void ignoreRepeatedWordsTest() {
        String repeatedWords = "stop stop stop STOP Stop";
        LWController controller = new LWController();
        doControllerTasks(controller, repeatedWords);

        ArrayList<String> s_result = new ArrayList<>(Arrays.asList("stop"));
        ArrayList<String> t_result = new ArrayList<>(Arrays.asList("stop"));
        ArrayList<String> o_result = new ArrayList<>(Arrays.asList("stop"));
        ArrayList<String> p_result = new ArrayList<>(Arrays.asList("stop"));

        assertEquals(s_result, controller.getWordsContainingTheLetter("s"));
        assertEquals(t_result, controller.getWordsContainingTheLetter("t"));
        assertEquals(o_result, controller.getWordsContainingTheLetter("o"));
        assertEquals(p_result, controller.getWordsContainingTheLetter("p"));
    }

    @Test
    public void ignoreDigitsNextToWords() {
        String digitsAndWords = "12364 stop5 65stop 759stop 689334 STOP 5669897Stop";
        LWController controller = new LWController();
        doControllerTasks(controller, digitsAndWords);

        ArrayList<String> s_result = new ArrayList<>(Arrays.asList("stop"));
        ArrayList<String> t_result = new ArrayList<>(Arrays.asList("stop"));
        ArrayList<String> o_result = new ArrayList<>(Arrays.asList("stop"));
        ArrayList<String> p_result = new ArrayList<>(Arrays.asList("stop"));

        assertEquals(s_result, controller.getWordsContainingTheLetter("s"));
        assertEquals(t_result, controller.getWordsContainingTheLetter("t"));
        assertEquals(o_result, controller.getWordsContainingTheLetter("o"));
        assertEquals(p_result, controller.getWordsContainingTheLetter("p"));
    }

    @Test
    public void ignoreDigitsWithinWords() {
        String repeatedWords = "st33op s54545454543top stop STOP Stop";
        LWController controller = new LWController();
        doControllerTasks(controller, repeatedWords);

        ArrayList<String> s_result = new ArrayList<>(Arrays.asList("stop"));
        ArrayList<String> t_result = new ArrayList<>(Arrays.asList("stop"));
        ArrayList<String> o_result = new ArrayList<>(Arrays.asList("stop"));
        ArrayList<String> p_result = new ArrayList<>(Arrays.asList("stop"));

        assertEquals(s_result, controller.getWordsContainingTheLetter("s"));
        assertEquals(t_result, controller.getWordsContainingTheLetter("t"));
        assertEquals(o_result, controller.getWordsContainingTheLetter("o"));
        assertEquals(p_result, controller.getWordsContainingTheLetter("p"));
    }

    private static void doControllerTasks(LWController controller, String userTxt) {
        controller.deleteAllLetterAndWordsFromRegistry();
        controller.setSentence(userTxt);
        controller.setUniqueLetters();
        controller.setUniqueWords();
        controller.addAllLetterAndWordsToRegistry();
    }
}