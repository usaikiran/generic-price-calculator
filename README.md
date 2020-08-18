# generic-price-calculator
A simple and generic price calculator designed in java.
It requires a config file to be configured which accepts components, its parts and resp. list of prices along with date range which defines its validity.

## Usage
git clone https://github.com/usaikiran/generic-price-calculator<br />
cd generic-price-calculator<br />
mvn clean package <br />
java -jar ./target/PriceCalculator-jar-with-dependencies.jar <input_json_file> <config_json_file><br />

### Config:

format : https://github.com/usaikiran/generic-price-calculator/blob/master/src/main/resources/samples/format-config.json <br/>
sample : https://github.com/usaikiran/generic-price-calculator/blob/master/src/main/resources/samples/sample-config.json <br />


### Input:

format : https://github.com/usaikiran/generic-price-calculator/blob/master/src/main/resources/samples/format-inputs.json <br/>
sample : https://github.com/usaikiran/generic-price-calculator/blob/master/src/main/resources/samples/sample-inputs.json <br />
