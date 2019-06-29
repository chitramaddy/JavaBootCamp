package com.company.U1M4SummativeMadhanChitra.controller;

import com.company.U1M4SummativeMadhanChitra.model.Answer;
import com.company.U1M4SummativeMadhanChitra.model.Definition;
import com.company.U1M4SummativeMadhanChitra.model.Quote;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class Quote_Word_Magic8_Service_Controller {

    Random random = new Random();
    int random1;

    //generate a random number below 10.

    //Get method to display quote of the day.
    @RequestMapping(value = "/quote", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Quote quoteOfTheDay() {

        random1 = random.nextInt(10);

        //Create a list of quote objects
        List<Quote> quoteList = new ArrayList<Quote>();

        Quote quote = new Quote("Ambrose Bierce", "Doubt is the father of invention.");
        quoteList.add(quote);

        quote = new Quote("Oscar Wilde", "Art is the most intense mode of individualism that the world has known.");
        quoteList.add(quote);

        quote = new Quote("Mason Cooley", "Cure for an obsession: get another one.");
        quoteList.add(quote);

        quote = new Quote("Friedrich Nietzsche", "That which does not kill us make us stronger.");
        quoteList.add(quote);

        quote = new Quote("Isaac Bashevis Singer", "The waste basket is the writer's best friend.");
        quoteList.add(quote);

        quote = new Quote("Plato", "Man: a being in search of meaning.");
        quoteList.add(quote);

        quote = new Quote("Gertrude Stein", "It is very easy to love alone.");
        quoteList.add(quote);

        quote = new Quote("Oscar Wilde", "Be yourself; everyone else is already taken.");
        quoteList.add(quote);

        quote = new Quote("Mahatma Gandhi", "Be the change that you wish to see in the world.");
        quoteList.add(quote);

        quote = new Quote("Unknown", "Stay away from negative people. They have a problem for every solution."
        );
        quoteList.add(quote);


        //Get quote-of-the-day from quoteList that has the index same as the random number generated.
        return quoteList.get(random1);

    }

    @RequestMapping(value = "/word", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Definition wordOfTheDay() {

        random1 = random.nextInt(10);

        //Create a list of quote objects
        List<Definition> wordList = new ArrayList<Definition>();

        Definition def = new Definition("Bon mot", ": a clever remark");
        wordList.add(def);

        def = new Definition("expatiate", "1. add details, such as to an account or idea" +
                "\n" +
                "2. clarify the meaning of and discourse in a learned way, usually in writing");
        wordList.add(def);

        def = new Definition("rostrum \\ ˈrä-strəm \\ noun", "1. a platform raised above the surrounding " +
                "level to give prominence to the person on it\n" +
                "\n" +
                "2. beak-like projection of the anterior part of the head of certain insects such as weevils");
        wordList.add(def);

        def = new Definition("pallid \\ ˈpa-ləd \\ adjective", "1. abnormally deficient in color as suggesting " +
                "physical or emotional distress\n" +
                "\n" +
                "2. (of light) lacking in intensity or brightness; dim or feeble\n" +
                "\n" +
                "3. lacking in vitality or interest or effectiveness");
        wordList.add(def);

        def = new Definition("travail \\ trə-ˈvāl , ˈtra-ˌvāl\\ noun and verb",
                "noun: use of physical or mental energy; hard work\n" +
                        "\n" +
                        "noun: concluding state of pregnancy; from the onset of contractions to the birth of a child\n" +
                        "\n" +
                        "verb: work hard");
        wordList.add(def);

        def = new Definition("acrimony \\ ˈa-krə-ˌmō-nē \\ noun",
                "1. anger and bitterness\n" +
                        "\n" +
                        "2. a rough and bitter manner");
        wordList.add(def);

        def = new Definition("protean \\ ˈprō-tē-ən , prō-ˈtē-\\ adjective", "taking on different forms");
        wordList.add(def);

        def = new Definition("polymath \\ ˈpä-lē-ˌmath \\ noun", ": a person of great and varied learning");
        wordList.add(def);

        def = new Definition("placate \\ ˈplā-ˌkāt , ˈpla- \\ verb",
                " cause to be more favorably inclined; gain the good will of");
        wordList.add(def);

        def = new Definition("gravitas \\ ˈgra-və-ˌtäs , -ˌtas \\ noun", " formality in bearing and appearance");
        wordList.add(def);


        //Get word-of-the-day from wordList that has the index same as the random number generated.
        return wordList.get(random1);
    }

    //This method takes in a JSON object with Key: value pair for question in it and returns a randomly generated answer.
    @RequestMapping(value = "/magic", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Answer getMagic8Answer(@RequestBody Answer question) {

        random1 = random.nextInt(10);

        List<String> ansList = new ArrayList<String>();

        ansList.add("Most likely");
        ansList.add("cannot predict now");
        ansList.add("My reply is no");
        ansList.add("Ask me later");
        ansList.add("I wish that's possible");
        ansList.add("It is certain");
        ansList.add("You may rely on it");
        ansList.add("It is decidedly so");
        ansList.add("Yes");
        ansList.add("Concentrate and ask again");

        Answer ans = new Answer();

        ans.setQuestion(question.getQuestion());
        ans.setAnswer(ansList.get(random1));

        return ans;
    }

}
