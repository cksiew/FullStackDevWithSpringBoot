import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import AddItem from './AddItem';
import List from '@material-ui/core/List';
import ListItem from '@material-ui/core/ListItem';
import ListItemText from '@material-ui/core/ListItemText';

class App extends Component {

  constructor(props){
    super(props);
    this.state = { items: [] };
    this.addItem = this.addItem.bind(this);
  }

  addItem = (item)=>{
    this.setState({items: [item, ...this.state.items]});
  }
  render() {
    const listItems = this.state.items.map((item, index)=>
    <ListItem key={index}>
    <ListItemText primary={item.product} secondary={item.amount} /></ListItem>)
    return (
      <div className="App">
       <h2>Shopping list</h2>
       <AddItem additem={this.addItem}/>
       <List>{listItems}</List>
      </div>
    );
  }
}

export default App;
