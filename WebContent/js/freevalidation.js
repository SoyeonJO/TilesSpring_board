/**
 * 
 */
String.prototype.validationNAME = function(){
	return /[가-힣]{2,4}$/.test(this);
};
String.prototype.validationEMAIL = function(){
	return /^[a-zA-Z0-9_-]+@[a-z]+(\.[a-z]+){1,2}$/.test(this);
};
String.prototype.validationPASSWORD = function(){
	return /[0-9]{4,4}$/.test(this);
};
String.prototype.validationTITLE = function(){
	return /[가-힣]+$/.test(this);
};
String.prototype.validationCONTENT = function() {
	return /[가-힣]+$/.test(this);
};