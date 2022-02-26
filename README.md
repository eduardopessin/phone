build:

    docker build -t jumia/phone .      
    docker run -p 8080:8080 jumia/phone

access:

    http://localhost:8080/customersView/
