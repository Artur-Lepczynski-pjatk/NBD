db.people.mapReduce(
	function (){
		this.credit.forEach(creditCard => {
			emit(creditCard.currency, creditCard.balance);
		});
	},
	function (key, values){
		return Array.sum(values);
	},
	{out: 'outputCollection_2'}
);

printjson(db.outputCollection_2.find().toArray());