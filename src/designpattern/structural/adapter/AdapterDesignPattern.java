package designpattern.structural.adapter;

interface WebDriver {
    public void getElement();
    public void selectElement();
}


class ChromeDriver implements WebDriver {

    @Override
    public void getElement() {
        System.out.println("Get element from ChromeDriver");
    }

    @Override
    public void selectElement() {
        System.out.println("Select element from ChromeDriver");

    }

}

class IEDriver {

    public void findElement() {
        System.out.println("Find element from IEDriver");
    }

    public void clickElement() {
        System.out.println("Click element from IEDriver");
    }

}

class WebDriverAdapter implements WebDriver {

    IEDriver ieDriver;

    public WebDriverAdapter(IEDriver ieDriver) {
        this.ieDriver = ieDriver;
    }

    @Override
    public void getElement() {
        ieDriver.findElement();

    }

    @Override
    public void selectElement() {
        ieDriver.clickElement();
    }

}

public class AdapterDesignPattern {

    public static void main(String[] args) {
        ChromeDriver a = new ChromeDriver();
        a.getElement();
        a.selectElement();
        System.out.println();

        IEDriver e = new IEDriver();
        e.findElement();
        e.clickElement();
        System.out.println();

        WebDriver wID = new WebDriverAdapter(e);
        wID.getElement();
        wID.selectElement();
        System.out.println();

    }

}
