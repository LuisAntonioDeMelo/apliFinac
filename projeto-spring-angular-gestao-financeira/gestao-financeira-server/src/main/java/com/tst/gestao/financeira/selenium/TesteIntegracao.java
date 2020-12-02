package com.tst.gestao.financeira.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TesteIntegracao {

    public static void main(String[] args) throws Exception {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Luis\\OneDrive\\Área de Trabalho\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:4200/lancamentos");

        // teste ok
        test1(driver,"2/11/2020","2/12/2020","despesa");
        Thread.sleep(3000);
        // teste fail
        test1(driver,"4/2/2021","2/12/2020","receita");

    }

    public static void test1(WebDriver driver,String dataPag, String dataVen,String status) {
        WebElement tipo = driver.findElement(By.id(status));
        tipo.click();

        WebElement dataPagamento = driver.findElement(By.id("dataPagamento"));
        dataPagamento.sendKeys(dataPag);

        WebElement dataVencimento = driver.findElement(By.id("dataVencimento"));
        dataVencimento.sendKeys(dataVen);

        WebElement descricao = driver.findElement(By.id("descricao"));
        descricao.sendKeys("Fatura do Cartao de Credito");

        WebElement valor = driver.findElement(By.id("valor"));
        valor.sendKeys("350");

        WebElement categoria = driver.findElement(By.id("categoria"));
        categoria.click();

        WebElement idCategoria = driver.findElement(By.xpath("//*[@id=\"1\"]"));
        idCategoria.click();

        WebElement pessoa = driver.findElement(By.id("pessoa"));
        pessoa.click();
        WebElement idpessoa = driver.findElement(By.xpath("//*[@id=\"pessoa-3\"]"));
        idpessoa.click();

        WebElement observacao = driver.findElement(By.id("observacao"));
        observacao.sendKeys("Este valor é corresponde ao valor mensal referente a fatura noBanko ");

        WebElement botaoSalvar = driver.findElement(By.id("btn-salvar"));
        botaoSalvar.click();
    }

}
