package steps;

import java.util.List;

import org.testng.Assert;

import java.util.Arrays;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.PaginaCursos;
import pages.PaginaFundamentosTesting;
import pages.PaginaPrincipal;
import pages.PaginaRegistro;

public class PaginaPrincipalSteps {
    
    PaginaPrincipal paginaPrincipal = new PaginaPrincipal();
    PaginaCursos cursosPage = new PaginaCursos();
    PaginaFundamentosTesting fundamentosPages = new PaginaFundamentosTesting();
    PaginaRegistro registroPage = new PaginaRegistro();

    @Given("I navegate to www.freerangetesters.com")
    public void iNaveteToFRT() {
        paginaPrincipal.navigateToFreeRangeTesters();
        
    }

    @When("I go to {word} using the navigation bar")
    public void navigationAllOptionsBarUse(String section) {
        paginaPrincipal.clickOnSectionNavigationBar(section);
    }

    @When("I select Elegir Plan")
    public void selectElegirPlan() {
        paginaPrincipal.clickOnEligirPlanButton();
    }

    @And("select Introducción al Testing")
    public void navigateToIntro() {
        cursosPage.clickFundamentosTestingLink();
        fundamentosPages.clickIntroduccionTestingLink();
    }

    @Then("I can validate the options in the checkout page")
    public void validateCheckoutPlans() {
        List<String> lista = registroPage.returnPlanDropdownValues();
        System.out.println(lista);
        List<String> listaEsperada = Arrays.asList("Academia: $16.99 / mes • 12 productos", "Academia: $176 / año • 12 productos", "Free: Gratis • 3 productos");
    
        Assert.assertEquals(listaEsperada, lista);
    }

    public void Ejemplulis() {
        String palabraEsperada = "Camila";
        String palabraEncontrada = "Kelvin";

    }
}
