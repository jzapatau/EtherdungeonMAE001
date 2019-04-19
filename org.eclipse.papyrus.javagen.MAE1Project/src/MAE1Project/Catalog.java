package MAE1Project;

//------------------ IMPORT MODULES ---------------------------//

//No modules to import

/************************************************************/
/**
* @author Felix Zapata
* Date: 3/04/2019
* 
* Catalog is an interface which allows to define the future catalogs
* and parametize the usage of the catalogs.
*/
public interface Catalog {
	public <T extends Individual> T instantiateIndividual(String name);
}
