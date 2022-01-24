db.people.mapReduce(
	function (){
		emit(this.job, null);
	},
	function (key, values){
		return 1;
	},
	{out: 'outputCollection_3'}
);

printjson(db.outputCollection_3.find().toArray());