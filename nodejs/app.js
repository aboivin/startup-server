var express = require("express");

var answer = function(question, req, res) {
	var m = question.match(/what is the sum of (\d+) and (\d+)/);
	if (m) {
		return +m[1] +  +m[2];
	}
	return 'team name';
}

var app = express();
	
app.get("/", function(req, res) {
    var q = req.param("q");
    var a = answer(q, req, res);
    console.log("Q: \"" + q + "\" A:\"" + a + "\"");
    res.end(a.toString());
});

app.listen(1338, "0.0.0.0");
console.log("Server running on http://0.0.0.0:1338/");
