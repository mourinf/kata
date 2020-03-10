package bowling;

import org.junit.Assert;
import org.junit.Test;

public class GameTest {

    @Test
    public void whenPlayingOnceAndKnocked0Pin_ShouldReturn0() {
        //Given
        Game game = new Game();
        game.roll(0);
        //When
        int result = game.score();
        //Then
        Assert.assertEquals(0, result);
    }

    @Test
    public void whenPlayingOnceAndKnocked10Pin_ShouldReturn10() {
        //Given
        Game game = new Game();
        game.roll(10);
        //When
        int result = game.score();
        //Then
        Assert.assertEquals(10, result);
    }

    @Test
    public void whenPlayingTwiceAndKnocked7And2Pin_ShouldReturn9() {
        //Given
        Game game = new Game();
        game.roll(7);
        game.roll(2);
        //When
        int result = game.score();
        //Then
        Assert.assertEquals(9, result);
    }

    @Test
    public void whenPlayingTwiceAndKnocked10And2Pin_ShouldReturn14() {
        //Given
        Game game = new Game();
        game.roll(10);
        game.roll(2);
        //When
        int result = game.score();
        //Then
        Assert.assertEquals(14, result);
    }

    @Test
    public void whenPlayingTwiceAndKnocked8And2Pin_ShouldReturn14() {
        //Given
        Game game = new Game();
        game.roll(8);
        game.roll(2);
        //When
        int result = game.score();
        //Then
        Assert.assertEquals(10, result);
    }

    @Test
    public void whenPlayingThreeAndKnocked8And2Then4Pin_ShouldReturn18() {
        //Given
        Game game = new Game();
        game.roll(8);
        game.roll(2);
        game.roll(4);
        //When
        int result = game.score();
        //Then
        Assert.assertEquals(18, result);
    }

    @Test
    public void whenPlayingThreeAndKnocked10Then2And4Pin_ShouldReturn22() {
        //Given
        Game game = new Game();
        game.roll(10);
        game.roll(2);
        game.roll(4);
        //When
        int result = game.score();
        //Then
        Assert.assertEquals(22, result);
    }

    @Test
    public void whenPlayingThreeAndKnocked0And10Then4Pin_ShouldReturn18() {
        //Given
        Game game = new Game();
        game.roll(0);
        game.roll(10);
        game.roll(4);
        //When
        int result = game.score();
        //Then
        Assert.assertEquals(18, result);
    }

    // Ici j'integre l'idee du compteur de tours + cas du 0 / 10
    @Test
    public void whenPlayingFourAndKnocked0And10Then4And6Pin_ShouldReturn24() {
        //Given
        Game game = new Game();
        game.roll(0);
        game.roll(10);
        game.roll(4);
        game.roll(6);
        //When
        int result = game.score();
        //Then
        Assert.assertEquals(24, result);
    }

    @Test
    public void whenPlayingFourAndKnocked10And8Then4And6Pin_ShouldReturn40() {
        //Given
        Game game = new Game();
        game.roll(10);
        game.roll(8);
        game.roll(4);
        game.roll(6);
        //When
        int result = game.score();
        //Then
        Assert.assertEquals(40, result);
    }

    //Integration du double strike
    @Test
    public void whenPlayingFourAndKnocked10And10Then4And6Pin_ShouldReturn54() {
        //Given
        Game game = new Game();
        game.roll(10);
        game.roll(10);
        game.roll(4);
        game.roll(6);
        //When
        int result = game.score();
        //Then
        Assert.assertEquals(54, result);
    }

    @Test
    public void whenPlayingFourAndKnocked10Then4And6Then0Pin_ShouldReturn30() {
        //Given
        Game game = new Game();
        game.roll(10);
        game.roll(4);
        game.roll(6);
        game.roll(0);
        //When
        int result = game.score();
        //Then
        Assert.assertEquals(30, result);
    }

    @Test
    public void fullPart_90() {
        //Given
        Game game = new Game();
        game.roll(9);
        game.roll(0);
        game.roll(9);
        game.roll(0);
        game.roll(9);
        game.roll(0);
        game.roll(9);
        game.roll(0);
        game.roll(9);
        game.roll(0);
        game.roll(9);
        game.roll(0);
        game.roll(9);
        game.roll(0);
        game.roll(9);
        game.roll(0);
        game.roll(9);
        game.roll(0);
        game.roll(9);
        game.roll(0);
        //When
        int result = game.score();
        //Then
        Assert.assertEquals(90, result);
    }

    @Test
    public void fullPartFullStrike_300() {
        //Given
        Game game = new Game();
        game.roll(10);
        game.roll(10);
        game.roll(10);
        game.roll(10);
        game.roll(10);
        game.roll(10);
        game.roll(10);
        game.roll(10);
        game.roll(10);
        game.roll(10);
        game.roll(10);
        game.roll(10);
        //When
        int result = game.score();
        //Then
        Assert.assertEquals(300, result);
    }

    @Test
    public void fullPartFullSpare_150() {
        //Given
        Game game = new Game();
        game.roll(5);
        game.roll(5);
        game.roll(5);
        game.roll(5);
        game.roll(5);
        game.roll(5);
        game.roll(5);
        game.roll(5);
        game.roll(5);
        game.roll(5);
        game.roll(5);
        game.roll(5);
        game.roll(5);
        game.roll(5);
        game.roll(5);
        game.roll(5);
        game.roll(5);
        game.roll(5);
        game.roll(5);
        game.roll(5);
        game.roll(5);
        //When
        int result = game.score();
        //Then
        Assert.assertEquals(150, result);
    }


}
