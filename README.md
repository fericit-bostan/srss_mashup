# srss_mashup
# author: Christopher Mathrusse

A Mashup of Google Maps and Earthtools web services deployed to a MuleSoft server.

This application exposes a local webservice, on port 8081, named getTimesForAddress

The webservice can be invoked as follows:

http://localhost:8081/getTimesForAddress?address=<address to be looked up>

Example: 

http://localhost:8081/getTimesForAddress?address=Bolyai+11+400096+Cluj+Romania

All embedded spaces must be replaced with a '+' character.

Upon invocation, the address will be sent to the Google Maps API where the geo coordinates will be retrieved. After which, the coordinates will then be passed to the EarthTools API where the sunrise and sunset times are retrieved. The results will be returned to the client as JSON outputing the requested address, the geo coordinates and the times of the sunrise and sunset for the supplied location (show in local time)

