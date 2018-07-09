import React, { Component } from 'react';
import SkyLight from 'react-skylight';
import RaisedButton from '@material-ui/core/Button';
import TextField from '@material-ui/core/TextField';

class AddItem extends Component {
    constructor(props){
        super(props);

        this.addItem = this.addItem.bind(this);
        this.handleChange = this.handleChange.bind(this);
    }

    // Create new shopping item and calls addItem function.
    // Finally close the modal form
    addItem = ()=>{
        const item = {product:this.state.product,
        amount:this.state.amount};
        this.props.additem(item);
        this.addform.hide();
    }

    handleChange = (e)=>{
        this.setState({[e.target.name]:e.target.value});
    }

    render(){
        return (
            <div>
                <section>
                    <RaisedButton onClick={()=> this.addform.show()} variant="raised" color="primary">Add Item</RaisedButton>
                </section>
                <SkyLight
                    hideOnOverlayClicked
                    ref={ref => this.addform = ref}
                    title="Add item">
                    <TextField type="text" name="product" onChange={this.handleChange}
                    placeholder="product" /><br />
                    <TextField type="text" name="amount" onChange={this.handleChange}
                    placeholder="amount" /><br />
                    <RaisedButton onClick={this.addItem} variant="default">Add</RaisedButton>
                </SkyLight>
            </div>
        );
    }
}

export default AddItem;