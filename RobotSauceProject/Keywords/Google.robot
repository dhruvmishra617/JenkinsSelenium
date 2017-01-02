*** Settings ***
Library    Selenium2Library
Library    Collections

*** Variables ***

${SAUCE_USER}    dhruvmishra617
${SAUCE_KEY}    baa04393-e3e8-434d-bdfb-0575bf55d0a4
${SAUCE_URL}    https://${SAUCE_USER}:${SAUCE_KEY}@ondemand.saucelabs.com:443/wd/hub
${URL}    http://www.google.com
@{SAUCE_OS}    Windows 10    Windows 7    OS X 10.11
@{SAUCE_BROWSER}    firefox    internet explorer    safari
@{SAUCE_VERSION}    49.0    11.0    10.0
${index}




*** Keywords ***
Open Google
    
    
   
      :FOR    ${OS}    IN    @{SAUCE_OS}
        \    ${index}    Get Index From List    ${SAUCE_OS}    ${OS}
        \    ${BROWSER}    Get From List    ${SAUCE_BROWSER}    ${index}
        \    ${VERSION}    Get From List    ${SAUCE_VERSION}    ${index}
        \    ${Caps}    Create Dictionary    platform=${OS}    browserName=${BROWSER}    version=${VERSION}
        \    Create Webdriver    Remote    desired_capabilities=${Caps}    command_executor=${SAUCE_URL}
        \    Go To    ${URL}
        \    Close Browser
      
    
   