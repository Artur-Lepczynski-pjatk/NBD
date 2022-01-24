db.people.mapReduce(
	function(){
		emit(this.sex, {weight: this.weight, height: this.height});
	},

	function(key, values){
		let sumWeight = 0;
		let sumHeight = 0;
		
		values.forEach(element => {
			sumWeight += element.weight;
			sumHeight += element.height;
		});
		
		return{
			avgWeight: sumWeight / values.length,
			avgHeight: sumHeight / values.length
		};
		
	},
	{out: 'outputCollection'}
);

printjson(db.outputCollection.find().toArray());