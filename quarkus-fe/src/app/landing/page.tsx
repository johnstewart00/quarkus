import { Button } from "@/components/ui/button";
import { getCartData } from "@/presenter/landingPresenter";
import Link from "next/link";
import { Cart, Options } from "../components/options";

export default async function Landing() {
  const cartData = await (await getCartData()).json();
  return (
    <div>
      <Button className="m-4">
        <Link href="/">Logout</Link>
      </Button>

      <div className="grid grid-cols-2 gap-4">
        <div className="flex flex-col items-center justify-center min-h-screen">
          <div className="m-4">Please click an item to add to your cart: </div>
          <Options />
        </div>
        <div className="flex flex-col items-center mt-10">
          <div>Your Cart:</div>
          {cartData?.items?.length > 0 ? (
            <ul className="m-4 flex flex-col gap-4">
              {cartData.items.map((item: any) => (
                <div key={item.id} className="border p-2">
                  {item.name}
                </div>
              ))}
            </ul>
          ) : (
            <div className="m-4">Your cart is empty</div>
          )}
        </div>
      </div>
    </div>
  );
}
