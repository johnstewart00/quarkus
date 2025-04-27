"use client";

import { Button } from "@/components/ui/button";
import { addToCart } from "@/presenter/landingPresenter";

export const Options = () => {
  const addItem = async (item: string) => {
    const res = await addToCart(item);
    console.log(res);
  };
  return (
    <ul className="m-4 flex gap-4">
      <Button onClick={() => addItem("Item 1")}>Item 1</Button>
      <Button onClick={() => addItem("Item 2")}>Item 2</Button>
      <Button onClick={() => addItem("Item 3")}>Item 3</Button>
    </ul>
  );
};
